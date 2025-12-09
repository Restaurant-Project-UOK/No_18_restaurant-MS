const BASE_URL = "http://localhost:8081/api/profile";

/**
 * Get current user's profile
 * @param {string} token JWT access token
 * @returns {Promise<Object>} Profile data
 */
export async function getProfile(token) {
  const res = await fetch(`${BASE_URL}/me`, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`,
    },
  });

  if (!res.ok) {
    const text = await res.text();
    throw new Error(`Failed to fetch profile: ${text}`);
  }

  return res.json();
}

/**
 * Update current user's profile
 * @param {string} token JWT access token
 * @param {Object} profileData
 * @returns {Promise<Object>} Updated profile data
 */
export async function updateProfile(token, profileData) {
  const res = await fetch(`${BASE_URL}/me`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}`,
    },
    body: JSON.stringify(profileData),
  });

  if (!res.ok) {
    const text = await res.text();
    throw new Error(`Failed to update profile: ${text}`);
  }

  return res.json();
}
