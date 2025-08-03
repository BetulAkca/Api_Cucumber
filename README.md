# 🧪 DevEx API Test Automation Project

This project is an automated API testing framework built with **Java**, **Rest Assured**, **Cucumber**, and **JUnit**.  
It is designed to test the backend endpoints of a user management system including registration, login, profile creation, and experience addition.

---

## 📁 Project Structure

- **`SignUp_stepDefs.java`**  
  Sends a POST request to register a new user and extract the authentication token.

- **`Profile_stepDefs.java`**
    - Retrieves all user profiles via GET requests.
    - Gets a specific user by ID and verifies the data.
    - Posts profile information (company, skills, social media links).
    - Verifies user name and email in the response.

- **Login & Experience Test Steps**
    - Logs in with valid credentials and stores access token.
    - Sends POST request to add professional experience to user profile.

---

## 🔧 Technologies Used

- Java
- Maven
- Rest Assured
- Cucumber
- JUnit
- JSON
- IntelliJ IDEA
- Postman (for manual testing)

---

## 🔄 Test Scenarios

- ✅ User Registration
- ✅ Token Verification
- ✅ Login with Credentials
- ✅ View All Profiles
- ✅ View Profile by ID
- ✅ Create & Save Profile
- ✅ Add Work Experience

---

## 🚀 How to Run the Tests

1. Clone the repository:
   ```bash
   git clone https://github.com/BetulAkca/Api_Cucumber.git
