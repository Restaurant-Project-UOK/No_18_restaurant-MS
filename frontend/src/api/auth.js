// src/api/auth.js

const BASE_URL = "http://localhost:8081/api/auth"; // matches @RequestMapping("/api/auth")

// Register (ignore response)
export async function register({ fullName, email, password, role = 1 }) {
  const res = await fetch(`${BASE_URL}/register`, {
    method: "POST",
    headers: { 
        "Content-Type": "application/json"
    },
    body: JSON.stringify({ fullName, email, password, role, provider: 1 }),
  });
    if (!res.ok) throw new Error("Registration failed");
        return res.json();
}

// Login (email + password)
export async function login({ email, password }) {
  const res = await fetch(`${BASE_URL}/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, password }),
  });
  if (!res.ok) throw new Error("Login failed");
    return res.json();
}

// Google OAuth login
export async function googleLogin({ email, token }) {
  const res = await fetch(`${BASE_URL}/google-login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ email, token }),
  });
  return res.json();
}
