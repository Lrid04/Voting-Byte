/**
 * @author Alex Cassady, Landon Riddick
 * @returns The users internet protocol address via fetching an api. Returns the users IP in a variable to be sent
 * over in other functions.
 */

export const getIp = async (): Promise<string | null> => {
    try {
      const response = await fetch("https://api.ipify.org/?format=json");
      const data = await response.json();
      return data.ip;
    } catch (error) {
      console.error("Error fetching IP address:", error);
      return null;
    }
  };
  