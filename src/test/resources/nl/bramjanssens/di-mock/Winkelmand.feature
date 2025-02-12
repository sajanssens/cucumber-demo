#language: nl
Functionaliteit: Toevoegen aan winkelmand
  Notitie voor developers: deze winkelmand werkt met DI.

  Voorbeeld: Toevoegen product aan winkelmand
    Gegeven Ik heb een lege mand.
    Als ik deze producten toevoeg aan mijn mand:
      | banaan |
      | wortel |
      | tv     |
    En de producten zijn op voorraad
    Dan zouden er 3 producten in mijn mandje moeten zitten