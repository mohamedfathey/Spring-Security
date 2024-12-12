# Spring Security Demo Application

## Overview
This application demonstrates how to use Spring Security to secure endpoints with Basic Authentication and role-based access control.

## Controller

### DemoController
- **`/demo` Endpoint**: Accessible to users with the `"read"` authority.
- **`/null` Endpoint**: Currently not secured and open to any authenticated user.

## Security Configuration

### SecurityFilterChain
- **Enables Basic Authentication** for HTTP requests.
- **Authorization Rules**:
    - `/demo`: Requires `"read"` authority.
    - All other endpoints: Requires authentication.

### UserDetailsService
- **InMemoryUserDetailsManager**:
    - Stores users in memory for demo purposes.
    - Users:
        - `mhmd` (Password: `123`, Authority: `"read"`)
        - `saif` (Password: `456`, Authority: `"play"`)
        - `khalid` (Password: `789`, Authority: `"manager"`)

### Password Encoding
- Uses **BCryptPasswordEncoder** for secure password hashing.

## Key Notes
1. `401 Unauthorized`: When the user is not authenticated.
2. `403 Forbidden`: When the user is authenticated but lacks the required authority.

## Usage
1. Access `/demo` with the credentials of a user with `"read"` authority (e.g., `mhmd`).
2. Any other endpoint requires valid authentication.
 
## Detailed Explanation of this methods

## `.anyRequest().hasAnyAuthority("play", "read")`
**Explanation:**
- Ensures that the request can only be accessed by users who have any of the specified authorities ("`play`" or "`read`").

**Use Case:** 
- Useful when`multiple roles` or authorities can access the same endpoint
```java
.anyRequest().hasAnyAuthority("admin", "user")
//Users with either "admin" or "user" authority can access any request.
```
### `.anyRequest().access("isAuthenticated() and hasAuthority('play')")`

**Explanation:** 
Allows more complex access control logic by using SpEL (Spring Expression Language). In this case:
- The user must be authenticated (`isAuthenticated()`).
- The user must also have the `play` authority (`hasAuthority('play')`).

**Use Case:** 
- Use this when you need conditional access rules that combine multiple checks.
```java
.anyRequest().access("hasRole('ADMIN') or (hasAuthority('read') and isRememberMe())")
//Allows access if:
//1. The user has the "ADMIN" role.
//2. OR the user has the "read" authority and is using a "remember-me" session.
```
---
### `denyAll()`
**Explanation:** 
- Denies access to all requests, 
irrespective of authentication or
roles. 
Results in a `403 Forbidden` response for any request.
---
**Use Case:**
- Useful when an endpoint is under maintenance or should not be accessible.

### `permitAll()`
**Explanation:** 
- Grants access to all users, including unauthenticated ones. No authorization checks are performed
**Use Case:** 
- Useful for public endpoints like login, registration, or health-check APIs.
---

### `authenticated()`
**Explanation:**
- Ensures that the request is only accessible to authenticated users. No specific roles or authorities are checked, just authentication.

**Use Case:**
- Useful when you need to restrict access to logged-in users but don’t want to enforce role-based restrictions.

## Complete Example: Combining All Methods
 ```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/public").permitAll()             // Anyone can access "/public"
            .antMatchers("/admin").hasAuthority("admin")    // Requires "admin" authority
            .antMatchers("/user").hasAnyAuthority("user", "editor") // Requires "user" or "editor" authority
            .antMatchers("/confidential").access("isAuthenticated() and hasAuthority('confidential')") // Custom rule
            .antMatchers("/maintenance").denyAll()          // No one can access "/maintenance"
            .anyRequest().authenticated()                   // All other endpoints require authentication
            .and()
            .build();
}

```
- `/public:` Open to everyone.
- `/admin`: Requires "`admin`" authority.
- `/user`: Requires "`user`" or "editor" authority.
- `/confidential`: Requires both authentication and "`confidential`" authority.
- `/maintenance`: Blocked for everyone.


# thanks **