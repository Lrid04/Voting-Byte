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