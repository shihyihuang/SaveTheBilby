# SaveTheBilby
The Bilby survival program will simulate one year of variation to a population of bilbies and their predators.
The simulation begins by displaying a brief welcome message. 
The user is then prompted for the name of area that the population data has been collected from. The name can be up to 16 characters in length.
The numbers of bilbies, foxes and feral cats at up to 10 locations is read in from a file population.txt. 
From this data, the program creates separate collections of bilbies, foxes and cats. 
Each animal will have a unique identification code, a location, and a status indicating whether it is alive or not. 
Foxes and cats will also have a health status. The details of these are as follows:
1. The unique identification code will be in the following format (where nnn represents a sequence of 3 digits):
   Bnnn for bilbies, Fnnn for foxes, Cnnn for cats
2. The location will be an integer, with the line from the file representing the location. 
3. All animals will be alive at the start of the simulation. 
4. The health status of foxes and cats will start at 3.
   
The simulation steps through 12 months. At each month the bilby population at each location is assessed, the conservationist makes any necessary interventions, 
and a summary of the bilby, fox, and cat populations at each location is displayed.  
At the end of the year, the population stability is assessed, the population data at each location is displayed, and a summary is written to the file populationFinal.txt. 

**Specific actions each month**

Each month the following events may occur:

1. New bilbies may be born. The probability of each bilby giving birth to a new bilby is 0.15.
   New foxes and cats may be born and added the population. The probability of each fox giving birth is 0.1. The probability of each cat giving birth is 0.2.  
2. A live fox may eat a bilby at the same location. Each fox has a 0.4 probability of eating a bilby if there is at least one bilby at the fox’s location. 
   If a fox eats a bilby then one bilby at the fox’s location has their alive status changed to false.  
   If the fox doesn’t eat a bilby then the fox’s health status is reduced by one. If a fox’s health status is zero then their alive status is changed to false.  
3. Similarly, a live cat may eat a bilby at the same location. Each cat has a 0.6 probability of eating a bilby if there is at least one bilby at the cat’s location. 
   If a cat eats a bilby then one bilby at the cat’s location has their alive status changed to false.  If the cat doesn’t eat a bilby then the cat’s health status is reduced by one. 
   If a cat’s health status is zero then their alive status is changed to false.  

After these events a summary of the population of live bilbies, foxes and cats at each location is displayed. At this point the conservationist may decide to:
1. relocate bilbies if their population at a location becomes too large. This involves changing the location of any bilbies in excess (more than 20). 
   If excess bilbies are not moved then their alive status changed to false. Relocations may happen each month.
2. conduct an intervention to reduce the number of predators. This involves hunting the foxes and cats.
    If this happens then the probability of eliminating each animal is 0.5. Interventions are expensive and may only happen once a year.

Specific actions at the completion of observations at all locations
At the end of the simulation the following summary is displayed on the screen. 

1. Population details at each location:
   Numbers of live bilbies, foxes and cats
   Numbers of bilbies, foxes and cats that have been born
   Numbers of bilbies, foxes and cats that have died
2. Bilby population change: 
   (total_bilbies_at_end - total_bilbies_at_start) * 100/ total_bilbies_at_start

3. Bilby population stability factor:
   (total_bilby_births + total_bilby_deaths) / total_bilbies_at_start
   The closer to 0 this factor is, the more stable the population.

4. Predator population change (a predator is a fox or cat):
  (total_predators_at_end - total_predators_at_start) * 100/ total_predators_at_start

