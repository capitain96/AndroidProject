# FS 2020 Companion App

The Idea of this app is provide a small companion app for the game "Microsoft Flight Simulator 2020" by Asobo and Microsoft.

---

### Current list of features that I strive to implement:
<ul>
  <li>List of all Aircrafts with technical imformation</li>
  <li>List of the hand built Airports with technical imformation</li>
  <li>Section with useful links to webpages of third party content</li>
  <li>small notebook to plan ideas for future flights</li>
</ul>

### Current list with planned features if possible:
<ul>
  <li>Logbook (if possible connected to the provided one with automatic updates, but this will probably not be possible)</li>
  <li>A plane matcher that chooses the perfect plane for your trip based on provided parameters</li>
  <li>Checklists for various planes</li>
</ul>

*Disclaimer: <br>
This list is subject to change.
Since I am not fully sure which skillsets we will aquire in this course some goals are dependent on the fact that we learn something to implement them or not.*

---

# Description of current features:

## Links to dedicated VATSIM data, like ILS approaches or transitions

Four buttons with important vatsim links can be found in the menu under "Vatsim"
Todo: more data should be added here

## Links to weather data, or built in ATIS

Link to windy.com is implemented
Now I strive to implement automatic location of the user and attachment of that data to the windy.com link to provide accurate weather info (Need help, doesn't work)

## Overwiev over recent patchnotes

Link to the last patchnote
Possibility for a list with all patchnotes and all links to these full patchnotes
maybe automate this? (Probably not with the current release format)

## List of available planes

This was implemented using an adapter which reads a JSON with the plane info.
CUrrently the pictures can't be displayed that way (Need help, doesn't work)
This will be implemented for the airports aswell.

## Other Features

<ul>
  <li>Dark Mode (Sort of)</li>
  <li>German translation</li>
 </ul>

---

# Current Issues:
<ul>
  <li>location service is not working</li>
  <li>Dark mode has hiccups</li>
  <li>Adapter JASON for image paths not working</li>
 </ul>

# Archieving the mandatory Points:
<ul>
  <li>Functionality</li>
  <li>Persistence</li>
  <li>Using webservices</li>
  <li>Layouts</li>
</ul>
