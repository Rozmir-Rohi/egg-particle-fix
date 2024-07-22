# Egg Particle Fix
Fixes MC-7807 (https://bugs.mojang.com/browse/MC-7807).
<br>
This project fixes the bug in 1.7.10 that used to make thrown eggs create snowball particles when they hit a block.
<br>
<br>
## Comparison of the 2 Versions of this Mod:
| No ASM Version                                                                                                                                                                                                   | ASM Version                                                                                                                                                                                                                                                           |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Works By:** Quickly teleporting Egg entities that  have been thrown by players into the void and creating a custom Egg entity in it's place that makes the correct particles  <br> <br> **Pros:** This version is highly compatible with other mods <br> <br> **Cons:** It's a dirty fix | **Works By:** Replacing the vanilla Egg entity code so that the vanilla Egg entity makes the correct particles <br> <br> **Pros:** It's a clean fix <br> <br> **Cons:** This version may be incompatible with other mods that try to edit the vanilla Egg entity code |
<br>
<br>
<br>

## Use of anatawa12's Fork of ForgeGradle 1.2 within Project:
The source code of this project uses anatawa12's fork of ForgeGradle 1.2 as a library under the GNU Lesser General Public License v2.1 (https://choosealicense.com/licenses/lgpl-2.1/).
 

Compiled versions of this mod are permitted under section 5 of the original license, "A program that contains no derivative of any portion of the Library, but is designed to work with the Library by being compiled or linked with it, is called a "work that uses the Library". Such a work...is not a derivative work of the Library"; consequently the conditions of the original license do not apply to the work.


The source code of this mod is permitted under section 6 of the original license, "you may also combine or link a "work that uses the Library" with the Library to produce a work containing portions of the Library, and distribute that work under terms of your choice" provided that:
* Private modifications are allowed.
* Notice is given that the Library is used and a copy of it's original license is provided.
* Access is provided to the source code of the Library.


The source code for anatawa12's fork of ForgeGradle 1.2 can be found here: https://github.com/anatawa12/ForgeGradle-1.2
