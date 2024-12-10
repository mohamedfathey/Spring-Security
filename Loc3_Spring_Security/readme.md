# Custom Authentication Implementation in Spring Security
#### This document explains the structure and purpose of the custom authentication implementation using Spring Security. Below is a detailed breakdown of the codebase, explaining each file and its functionality, along with a line-by-line explanation.

### Overview of the Codebase
**Topics Covered:**

1. CustomAuthentication: Represents authentication data.
2. CustomAuthenticationFilter: Intercepts requests and extracts authentication data.
3. CustomAuthenticationManager: Manages authentication by delegating to the appropriate provider.
4. CustomAuthenticationProvider: Validates authentication credentials.
5. SecurityConfig: Configures Spring Security and integrates the custom filter.

---
# 1__ Custom Authentication
**File:** `CustomAuthentication.java`

his class implements Spring Security's `Authentication` *interface* to represent
an authentication object with custom properties.
**Key Methods:**
- `isAuthenticated`: Returns whether the user is authenticated.
- `setAuthenticated`: Allows setting the authentication status.
- `getAuthorities`: Returns user roles or permissions (not implemented here).
- `getCredentials`, `getDetails`, `getPrincipal`: Placeholder methods for advanced user data handling.
- `getName`: Returns the name of the authenticated principal (not used here).
```java
public class CustomAuthentication implements Authentication {
    private boolean authentication; // Authentication status
    private String kay; // Custom authentication key

    public CustomAuthentication(boolean authentication, String kay) {
        this.authentication = authentication; // Set authentication status
        this.kay = kay; // Store the custom key
    }

    public boolean isAuthenticated() { 
        return authentication; // Return authentication status
    }
    // Additional methods as placeholders for Spring Security compliance
}
```
# 2__ CustomAuthenticationFilter

**File**: `CustomAuthenticationFilter.java`

This filter intercepts HTTP requests and extracts authentication data (custom key from the header).

**Key Method:**

`doFilterInternal`: The main logic for extracting the key, creating a custom authentication object, and passing it to the authentication manager.
```java
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager;

    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager; // Inject manager dependency
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String kay = request.getHeader("kay"); // Extract key from request header
        CustomAuthentication ca = new CustomAuthentication(false, kay); // Create unauthenticated object
        var a = customAuthenticationManager.authenticate(ca); // Delegate to manager for authentication

        if (a.isAuthenticated()) { 
            SecurityContextHolder.getContext().setAuthentication(a); // Set authentication in context
            filterChain.doFilter(request, response); // Allow the request to proceed
        }
    }
}
```
# 3__ CustomAuthenticationManager
**File:** `CustomAuthenticationManager.java`

This class implements AuthenticationManager and delegates authentication to a specific provider.

**Key Method:**

`authenticate`: Calls the provider to validate the custom authentication object.

```java
@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private final CustomAuthenticationProvider authenticationProvider;

    public CustomAuthenticationManager(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider; // Inject provider dependency
    }

    @Override
    public Authentication authenticate(Authentication authentication) {
        if (authenticationProvider.supports(authentication.getClass())) {
            return authenticationProvider.authenticate(authentication); // Delegate to provider
        }
        throw new BadCredentialsException("Invalid authentication type");
    }
}
```
# 4__ CustomAuthenticationProvider
**File:** `CustomAuthenticationProvider.java`

This class contains the logic for validating the custom key against a configured secret.

**Key Methods:**

`authenticate`: Compares the provided key with the secret key.

`supports`: Ensures the provider only handles CustomAuthentication objects.
```java
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${our.very.very.very.secret.key}")
    private String kay; // Secret key from configuration

    @Override
    public Authentication authenticate(Authentication authentication) {
        CustomAuthentication ca = (CustomAuthentication) authentication;
        if (kay.equals(ca.getKay())) {
            return new CustomAuthentication(true, null); // Return authenticated object
        }
        throw new BadCredentialsException("Invalid key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication); // Only handle CustomAuthentication
    }
}
```
# 5__ SecurityConfig
**File:** `SecurityConfig.java`

This configuration class integrates the custom authentication filter into Spring Security's filter chain.

**Key Method:**

`securityFilterChain`: Adds the custom filter to the chain and enforces authentication for all requests.
```java
@Configuration
public class SecurityConfig {
    private final CustomAuthenticationFilter customAuthenticationFilter;

    public SecurityConfig(CustomAuthenticationFilter customAuthenticationFilter) {
        this.customAuthenticationFilter = customAuthenticationFilter; // Inject filter dependency
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // Add custom filter
                .authorizeRequests().anyRequest().authenticated() // Enforce authentication
                .and().build(); // Build the security chain
    }
}
```
## How It Works
1. **Request Interception:**
   Every incoming request is intercepted by `CustomAuthenticationFilter`.
2. **Key Extraction:**
   The filter extracts the authentication key (`kay`) from the request header.
3. **Authentication Attempt:**
   An unauthenticated `CustomAuthentication` object is created and passed to `CustomAuthenticationManager`.
4. **Authentication Validation:**
   The manager forwards the object to `CustomAuthenticationProvider`, which validates the key.
5. **Result:**
    
    *If valid*: The object is marked authenticated and saved in `SecurityContextHolder`.

    *If invalid*: An exception is thrown, and access is denied.

## Dependencies and Configuration
- Spring Boot Starter Security
- Add the following to application.properties
```properties
our.very.very.very.secret.key=secret
```
## Customization
- Replace `our.very.very.very.secret.key` with your desired key.
- Enhance `CustomAuthentication` to include roles or additional user details if needed.






