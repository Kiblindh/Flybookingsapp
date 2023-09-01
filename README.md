# Flybookingsapp
Flybookingsapp laget i faget TDT4100 - Objektorientert programmering

Appen ble laget i Java og Java FXML

## Dokumentasjon om applikasjonen
Appen består av en UI mappe og en Booking Class mappe som inneholder logikken bak
appen. Appen leser først inn en liste med gyldige lokasjoner fra en Locations.txt fil. Disse
lokasjonene regulerer hva slags lokasjoner som er mulige å opprette flights med
(forhåndsprogrammet inn). Når appen åpnes så må brukeren først velge hvor flyet skal gå
fra, så hvor det skal til, datoen og tidspunktet. Brukeren får så opp et forslag med fra, til,
dato og sted når de trykker på de ulike knappene. Til slutt, så trykker de på booking-knappen
og får skrevet ut en kvittering over bookingen deres i booking.txt. Hvis brukeren endrer på
noen av feltene f.eks fra når de har fylt inn de andre, så vil de få en feilmelding når de
trykker på booking-knappen. Videre, så kan brukeren også trykke på exit i menyen underveis
for å slutte bookingen og dermed ikke booke noe fly. Da får den opp en informasjonsalert
som beskriver at brukeren har gått ut av appen. I tillegg, så inneholder appen en pris
comparator. Ved å trykke på denne, så får brukeren opp den billigste flighten først når det er
flere tilgjengelige flygninger på ulike tidspunkter og datoer.
