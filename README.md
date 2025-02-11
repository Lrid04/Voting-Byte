# NEW Byte Jam Voting App

The new and improved Byte Jam voting app/admin!

## About

This project is meant to act as a replacement for the current Byte Jam voting app and 
admin. It is currently still a work in progress, but out aim is to fix all the issues 
with the current Byte Jam app, as well as to make it a much more streamlined and 
user-friendly experience

## Use

The intended use for this app is during the Indian Hills Byte Jam event. It will allow
all attendees of the event to rate the teams present. This app also has an admin, which
is to be used by the Byte Jam planning committee to enter all the teams, coaches, judges
and companies that will be attending the event

## Tech Stack

<details>
  <summary>Front End</summary>
  <ul>
    <li>Typescript</li>
    <li>Next.js</li>
    <li>React.js</li>
    <li>TailwindCSS</li>
  </ul>
</details>

<details>
  <summary>Back End</summary>
  <ul>
    <li>Java</li>
    <li>SpringBoot</li>
  </ul>
</details>

<details>
<summary>Database</summary>
  <ul>
    <li>SQLite</li>
  </ul>
</details>

## Features

- A clear results page in admin
- Individual teams/coaches/judges/companies can now be dropped, in addition to a drop all
- Admin page is protected by a username and password
- Users can no longer reset the app and vote multiple times
- Users can now search for specific teams

## Things to be added

- Convert pins to a pdf
- Convert results to a pdf
- Styling

## Front End Wireframes

### Admin Page

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733721625104428/Admin_Home_Page.png?ex=67aad08a&is=67a97f0a&hm=e5a119e69dea85a5412388cb57684be202e9890011cc20df5539b0ccd591b065&" alt="Admin Home Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733721159798865/Byte_Jam_Admin_Page.png?ex=67aad08a&is=67a97f0a&hm=ac4538929d293644a42397a18a6a703ce24957a54f4b9e80969f7a456b37d344&" alt="Admin Teams Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733720752816198/Company_Page.png?ex=67aad08a&is=67a97f0a&hm=ec69eea1bafb2b5ad0b79515831b555ed06b812d818dff28cf5f2ebae27b420c&" alt="Admin Companies Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733720341643294/Coaches_Judges_Page.png?ex=67aad08a&is=67a97f0a&hm=f68481150fd9c8e7efa8aa47b140c9a8015f91d873ed29853cdf31117ef9017b&" alt="Admin Coaches/Judges Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733718756327566/Winners_Page.png?ex=67aad089&is=67a97f09&hm=7bbaf02293fe3afcee49e93b957a1995821a35c95322afd2a7b80b8b8fb691bc&" alt="Admin Coaches/Judges Page" width="200"/>

### App

<img src="https://cdn.discordapp.com/attachments/1149333573497786459/1338528645576396800/image.png?ex=67ab6971&is=67aa17f1&hm=e71c3c9ab5faac7b4dd848b809dd0f35b57d3ba4f1b35346fa0d3afcde4d2d0f&" alt="Home Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733719553245276/Voting_App_Pin.png?ex=67aad08a&is=67a97f0a&hm=b35babb899d787e6fc87482c40ad82e888a54a660f3a52077a3c611d106bf8ae&" alt="Pin Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733719876341770/Admin_Sign_In.png?ex=67aad08a&is=67a97f0a&hm=ea9f74bad2815f08097e4be347233323eaf49202759166458df519d2292a4e8a&" alt="Admin Login Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733719288873041/Team_Select.png?ex=67aad089&is=67a97f09&hm=8dea8190b4d4375f3798b8256a532357e26972857d0e586d850d807cfd24fb61&" alt="Team Select Page" width="200"/>

<img src="https://cdn.discordapp.com/attachments/1197560061149597787/1336733719029092473/Voting_Page.png?ex=67aad089&is=67a97f09&hm=3b5740321547e5ed7fc2321a9b31ae70dd3b9f2139ebad23b1b5278867291c3f&" alt="Voting Page" width="200"/>

## Getting Started

### Prerequisites

You need Node to run this project

```bash
 # Download and install fnm:
winget install Schniz.fnm

# Download and install Node.js:
fnm install 22

# Verify the Node.js version:
node -v # Should print "v22.13.1".

# Verify npm version:
npm -v # Should print "10.9.2".
```

### Run Locally

Clone the project
```bash
git clone https://github.com/Lrid04/Voting-Byte.git
```

Run the back end

In the front end, in the terminal type:

```bash
npm run Dev

npm run Build

nmp run Start
```

## Contributors 

Alex Cassidy
Aiden Conrad
Landon Riddick
Kofi Takpah Souka