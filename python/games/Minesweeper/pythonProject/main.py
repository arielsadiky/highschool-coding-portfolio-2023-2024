import json
import urllib.request

# Replace with your actual Google Developer API key
API_KEY = "AIzaSyC1x40vedfaaSprM84BHsAHx4JnW01uqbo"
url = f"https://www.googleapis.com/webfonts/v1/webfonts?key={API_KEY}"

# 1. Fetch the raw Google Fonts payload
response = urllib.request.urlopen(url)
data = json.loads(response.read())

# 2. Filter for families containing the Hebrew language subset
hebrew_fonts = []
for font in data.get("items", []):
    if "hebrew" in font.get("subsets", []):
        hebrew_fonts.append(font["family"])

# 3. Output a beautiful, clean local JSON file
with open("hebrew_fonts.json", "w", encoding="utf-8") as f:
    json.dump({"fonts": hebrew_fonts}, f, indent=4)

print(f"Success! Generated a list of {len(hebrew_fonts)} Hebrew-compatible fonts.")
