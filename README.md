# FS 2020 Companion App

The Idea of this app is provide a small companion app for the game "Microsoft Flight Simulator 2020" by Asobo and Microsoft.

---

### Current list of features that I strive to implement:
<ul>
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

## Links to weather data, or built in ATIS

Link to windy.com is implemented
And it does automatically bring up the weather data of your current location. (this needs a little fine tuning)

## Overwiev over recent patchnotes

Link to the last patchnote
Possibility for a list with all patchnotes and all links to these full patchnotes
maybe automate this? (Probably not with the current release format)

## List of available planes

This was implemented using an adapter which reads a JSON with the plane info.

## List of your favorite Airports

This was implemented using an adapter which reads a JSON with the airport info.
So you can simply add your favorite airports to that json file and upload it.

## Other Features

<ul>
  <li>Dark Mode (Sort of)</li>
  <li>German translation</li>
 </ul>

---

# Current Issues:
<ul>
  <li>The list of airplanes is funky, fix this by changing the view</li>
  <li>Just to be sure we should also do that with the airport view</li>
  <li>Translate the whole notes app into german</li>
  <li></li>
 </ul>

# Archieving the mandatory Points:
<ul>
  <li>Functionality</li>
  <li>Persistence</li>
  <li>Using webservices</li>
  <li>Layouts</li>
</ul>
