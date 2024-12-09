# Negative Login Scenarios

## Scenario 1: Invalid Username and Valid Password
- **Given** user is on the login page
- **When** the user enters an invalid username and a valid password
- **And** the user clicks on the login button
- **Then** the user should see an error message indicating invalid credentials.

## Scenario 2: Valid Username and Invalid Password
- **Given** user is on the login page
- **When** the user enters a valid username and an invalid password
- **And** the user clicks on the login button
- **Then** the user should see an error message indicating invalid credentials.

## Scenario 3: Invalid Username and Invalid Password
- **Given** user is on the login page
- **When** the user enters both username and password incorrectly
- **And** the user clicks on the login button
- **Then** the user should see an error message indicating invalid credentials.

## Scenario 4: Empty Username or Password
- **Given** user is on the login page
- **When** the user enters an empty username or password
- **And** the user clicks on the login button
- **Then** the user should see an error message indicating missing credentials.

## Scenario 5: SQL Injection in Credentials
- **Given** user is on the login page
- **When** the user tries to inject SQL through the username or password field
- **And** the user clicks on the login button
- **Then** the system should prevent the login and may log the attempt for security monitoring.

## Scenario 6: Cross-Site Scripting (XSS) Attacks
- **Given** user is on the login page
- **When** the user tries to inject JavaScript or HTML content into the username or password fields
- **And** the user clicks on the login button
- **Then** the system should sanitize the input and prevent the login, displaying an appropriate error message.

## Scenario 7: Buffer Overflow in Credentials
- **Given** user is on the login page
- **When** the user enters excessively long strings as username or password
- **And** the user clicks on the login button
- **Then** the system should handle the input without crashing and display an error message if necessary.

## Scenario 8: Use of Special Characters in Credentials
- **Given** user is on the login page
- **When** the user includes special characters or spaces in the username or password
- **And** the user clicks on the login button
- **Then** the system should correctly process the input and display an error message if the credentials are incorrect.

## Scenario 9: Case Sensitivity in Username or Password
- **Given** user is on the login page
- **When** the user alters the case of letters in the username or password
- **And** the user clicks on the login button
- **Then** the system should treat the credentials as case-sensitive and display an error message if they do not match exactly.

## Scenario 10: Simultaneous Login Attempts
- **Given** user is on the login page
- **When** the user attempts to log in from multiple devices or browsers at the same time with the same credentials
- **And** the user clicks on the login button
- **Then** the system should manage concurrent sessions appropriately and may restrict simultaneous logins if configured to do so.

## Scenario 11: Session Timeout After Failed Login Attempts
- **Given** user is on the login page
- **When** the user makes multiple consecutive failed login attempts
- **And** the user clicks on the login button
- **Then** the system should enforce a timeout or account lockout policy to enhance security.

## Scenario 12: Network Failure During Login Process
- **Given** user is on the login page
- **When** there is a network disconnection or failure during the login process
- **And** the user clicks on the login button
- **Then** the system should gracefully handle the disruption and inform the user of the issue.

## Scenario 13: Browser Compatibility
- **Given** user is on the login page
- **When** the user tries to log in using different web browsers and versions
- **And** the user clicks on the login button
- **Then** the login functionality should work consistently across all tested browsers.

## Scenario 14: Accessibility Compliance
- **Given** user is on the login page
- **When** the user tests the login page and error messages for accessibility
- **And** the user clicks on the login button
- **Then** the system should ensure that all elements are accessible, including compatibility with screen readers and adequate contrast for visually impaired users.

## Scenario 15: Localization and Internationalization
- **Given** user is on the login page
- **When** the user tests the login process with usernames and passwords containing non-Latin characters
- **And** the user clicks on the login button
- **Then** the system should support international users effectively, handling a variety of character sets correctly.
