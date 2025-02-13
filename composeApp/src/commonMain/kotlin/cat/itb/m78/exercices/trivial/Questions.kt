package cat.itb.m78.exercices.trivial

val questions = listOf(
    // Historia
    Question(
        text = "Quina civilitzacio va construir les piramides d'Egipte?",
        options = listOf("Egipcis", "Romans", "Grecs", "Maians"),
        correctAnswerIndex = 0,
        category = "Historia"
    ),
    Question(
        text = "Qui va ser una figura destacada de la Revolucio Francesa?",
        options = listOf("Napoleo", "Robespierre", "Luis XVI", "Voltaire"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "En quin any va acabar la Segona Guerra Mundial?",
        options = listOf("1940", "1945", "1950", "1939"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "Quina cultura va construir Machu Picchu?",
        options = listOf("Incas", "Aztecs", "Olmecs", "Mayas"),
        correctAnswerIndex = 0,
        category = "Historia"
    ),
    Question(
        text = "Quin explorador va descobrir America el 1492?",
        options = listOf("Cristofor Colom", "Vasco da Gama", "Ferdinand Magellan", "Amerigo Vespucci"),
        correctAnswerIndex = 0,
        category = "Historia"
    ),
    Question(
        text = "Qui va ser el primer president dels Estats Units?",
        options = listOf("Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "Quina guerra es va lluitar entre 1914 i 1918?",
        options = listOf("Guerra de Corea", "Primera Guerra Mundial", "Segona Guerra Mundial", "Guerra del Vietnam"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "Quin imperi va dominar el Mediterrani durant segles?",
        options = listOf("Imperi Otoma", "Imperi Roma", "Imperi Bizanti", "Imperi Persa"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "En quin any va caure l'Imperi Roma d'Occident?",
        options = listOf("410", "476", "500", "395"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "Qui va lluitar contra l'apartheid a Sud-africa?",
        options = listOf("Nelson Mandela", "Desmond Tutu", "F.W. de Klerk", "Steve Biko"),
        correctAnswerIndex = 0,
        category = "Historia"
    ),
    Question(
        text = "Quina civilitzacio antiga construia temples escalonats anomenats 'zigurat'?",
        options = listOf("Babilonica", "Egipcia", "Mesopotamica", "Persa"),
        correctAnswerIndex = 2,
        category = "Historia"
    ),
    Question(
        text = "Qui va pintar el famos fresc 'La Creacio d'Adam' a la Capella Sixtina?",
        options = listOf("Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello"),
        correctAnswerIndex = 1,
        category = "Historia"
    ),
    Question(
        text = "Quina batalla va marcar la derrota final de Napoleo?",
        options = listOf("Austerlitz", "Trafalgar", "Leipzig", "Waterloo"),
        correctAnswerIndex = 3,
        category = "Historia"
    ),
    Question(
        text = "Quina civilitzacio va construir el Parteno d'Atenes?",
        options = listOf("Egipcia", "Romana", "Grega", "Persa"),
        correctAnswerIndex = 2,
        category = "Historia"
    ),
    Question(
        text = "En quin any es va produir la caiguda del Mur de Berlin?",
        options = listOf("1989", "1991", "1985", "1990"),
        correctAnswerIndex = 0,
        category = "Historia"
    ),

    // Ciencia
    Question(
        text = "Quin es l'element quimic amb el simbol 'O'?",
        options = listOf("Osmio", "Oxigen", "Or", "Oganesson"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quina teoria va formular Albert Einstein?",
        options = listOf("Teoria de la relativitat", "Teoria de l'evolucio", "Teoria quantica", "Teoria atomica"),
        correctAnswerIndex = 0,
        category = "Ciencia"
    ),
    Question(
        text = "Quina part del cos huma produeix la insulina?",
        options = listOf("Cor", "Fesss", "Pancrees", "Pulmons"),
        correctAnswerIndex = 2,
        category = "Ciencia"
    ),
    Question(
        text = "Quin gas es essencial per a la respiracio humana?",
        options = listOf("Dioxid de carboni", "Oxigen", "Nitrogen", "Hidrogen"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quin cientific va proposar la llei de la gravitacio universal?",
        options = listOf("Isaac Newton", "Galileo Galilei", "Nikola Tesla", "Albert Einstein"),
        correctAnswerIndex = 0,
        category = "Ciencia"
    ),
    Question(
        text = "Quin es el planeta mes proper al Sol?",
        options = listOf("Mart", "Venus", "Mercuri", "Terra"),
        correctAnswerIndex = 2,
        category = "Ciencia"
    ),
    Question(
        text = "Quin organisme converteix la llum solar en energia?",
        options = listOf("Fongs", "Bacteris", "Algues", "Plantes"),
        correctAnswerIndex = 3,
        category = "Ciencia"
    ),
    Question(
        text = "Quina branca de la biologia estudia els animals?",
        options = listOf("Botanica", "Zoologia", "Geologia", "Astronomia"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quin es l'organ mes gran del cos huma?",
        options = listOf("Cor", "Pell", "Fetge", "Ronyo"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quin element quimic te el nombre atomic 1?",
        options = listOf("Heli", "Hidrogen", "Liti", "Carboni"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quin proces utilitzen les plantes per fabricar el seu aliment?",
        options = listOf("Respiracio", "Digestio", "Fotosintesi", "Metabolisme"),
        correctAnswerIndex = 2,
        category = "Ciencia"
    ),
    Question(
        text = "Quina es la unitat basica de la vida?",
        options = listOf("Molecule", "Teixit", "Cellula", "Atom"),
        correctAnswerIndex = 2,
        category = "Ciencia"
    ),
    Question(
        text = "Quin es el principal component de les estrelles?",
        options = listOf("Oxigen", "Hidrogen", "Carboni", "Heli"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),
    Question(
        text = "Quin tipus d'energia es genera a partir d'una explosio nuclear?",
        options = listOf("Energia cinetica", "Energia quimica", "Energia electrica", "Energia nuclear"),
        correctAnswerIndex = 3,
        category = "Ciencia"
    ),
    Question(
        text = "Quin instrument s'utilitza per mesurar la temperatura?",
        options = listOf("Barometre", "Termometre", "Higrometre", "Altimetre"),
        correctAnswerIndex = 1,
        category = "Ciencia"
    ),

    // Esports
    Question(
        text = "Quin pais va guanyar la Copa del Mond de Futbol el 2010?",
        options = listOf("Alemania", "Italia", "Espanya", "Brasil"),
        correctAnswerIndex = 2,
        category = "Esports"
    ),
    Question(
        text = "Quin esport es juga amb una pilota i una raqueta a la ma?",
        options = listOf("Basquet", "Tenis", "Voleibol", "Futbol"),
        correctAnswerIndex = 1,
        category = "Esports"
    ),
    Question(
        text = "En quin esport s'organitza una marato?",
        options = listOf("Natacio", "Ciclisme", "Atletisme", "Esqui"),
        correctAnswerIndex = 2,
        category = "Esports"
    ),
    Question(
        text = "Quin es el nom de la competicio europea de futbol interclubs?",
        options = listOf("Champions League", "Copa del Rei", "Supercopa", "Lliga"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "Qui es conegut com el 'Rei del Futbol'?",
        options = listOf("Lionel Messi", "Cristiano Ronaldo", "Pele", "Diego Maradona"),
        correctAnswerIndex = 2,
        category = "Esports"
    ),
    Question(
        text = "Quin esport utilitza un basto llarg i un disc volador?",
        options = listOf("Hoquei sobre herba", "Basquet", "Voleibol", "Rugbi"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "En quin esport s'utilitza una canya per jugar?",
        options = listOf("Golf", "Podel", "Ciclisme", "Esgrima"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "Quin pais ha guanyat mes titols en la Copa del Mond de Futbol?",
        options = listOf("Alemania", "Brasil", "Argentina", "Franca"),
        correctAnswerIndex = 1,
        category = "Esports"
    ),
    Question(
        text = "Quin esport te com a principal trofeu la 'Stanley Cup'?",
        options = listOf("Hoquei sobre gel", "Basquet", "Futbol american", "Lacrosse"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "Qui es conegut com el 'GOAT' del basquet?",
        options = listOf("LeBron James", "Kobe Bryant", "Michael Jordan", "Magic Johnson"),
        correctAnswerIndex = 2,
        category = "Esports"
    ),
    Question(
        text = "En quin esport s'utilitza una pala i una pilota petites, sovint jugat a taules?",
        options = listOf("Tenis de taula", "Billar", "Badminton", "Ping-pong"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "Quin esport s'associa amb el rem?",
        options = listOf("Rem", "Natacio", "Ciclisme", "Atletisme"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),
    Question(
        text = "Quin esport implica lluitar en un ring?",
        options = listOf("Lluita lliure", "Boxa", "Judo", "Taekwondo"),
        correctAnswerIndex = 1,
        category = "Esports"
    ),
    Question(
        text = "Quin pais va acollir els Jocs Olimpics de 1992?",
        options = listOf("Atenes", "Barcelona", "Sydney", "Atlanta"),
        correctAnswerIndex = 1,
        category = "Esports"
    ),
    Question(
        text = "Quin esport d'equip compta amb porters?",
        options = listOf("Futbol", "Basquet", "Rugbi", "Voleibol"),
        correctAnswerIndex = 0,
        category = "Esports"
    ),

    // Cultura Pop
    Question(
        text = "Qui es l'autor de la saga 'Harry Potter'?",
        options = listOf("J.R.R. Tolkien", "J.K. Rowling", "Stephen King", "George R.R. Martin"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quin superheroi diu 'Amb gran poder ve una gran responsabilitat'?",
        options = listOf("Batman", "Superman", "Spider-Man", "Iron Man"),
        correctAnswerIndex = 2,
        category = "Pop"
    ),
    Question(
        text = "Quina serie de televisio tracta sobre un grup d'amics a Nova York?",
        options = listOf("Friends", "The Office", "How I Met Your Mother", "Seinfeld"),
        correctAnswerIndex = 0,
        category = "Pop"
    ),
    Question(
        text = "Qui es el creador dels comics de 'Batman'?",
        options = listOf("Stan Lee", "Bob Kane", "Jack Kirby", "Alan Moore"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quin artista va llancar l'album 'Thriller'?",
        options = listOf("Prince", "Elvis Presley", "Michael Jackson", "Madonna"),
        correctAnswerIndex = 2,
        category = "Pop"
    ),
    Question(
        text = "En quin any es va estrenar la primera pellicula de 'Star Wars'?",
        options = listOf("1977", "1980", "1969", "1983"),
        correctAnswerIndex = 0,
        category = "Pop"
    ),
    Question(
        text = "Quin es el nom del robot en la pellicula 'Wall-E'?",
        options = listOf("EVE", "R2-D2", "BB-8", "C-3PO"),
        correctAnswerIndex = 0,
        category = "Pop"
    ),
    Question(
        text = "Quin cantant es coneix com el 'Rei del Pop'?",
        options = listOf("Elvis Presley", "Michael Jackson", "Prince", "Freddie Mercury"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quina serie de televisio te com a protagonista un professor de quimica convertit en cap d'un imperi de drogues?",
        options = listOf("The Sopranos", "Breaking Bad", "Ozark", "Narcos"),
        correctAnswerIndex = 1,
        category = "Cultura Pop"
    ),
    Question(
        text = "Quin videojoc presenta personatges com Mario i Luigi?",
        options = listOf("Sonic", "Super Mario", "Zelda", "Pac-Man"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quin es el nom del continent fictici de 'Game of Thrones'?",
        options = listOf("Westeros", "Narnia", "Middle-earth", "Hogwarts"),
        correctAnswerIndex = 0,
        category = "Pop"
    ),
    Question(
        text = "Quin grup musical va ser famos amb la canco 'Bohemian Rhapsody'?",
        options = listOf("The Beatles", "Queen", "Nirvana", "Led Zeppelin"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quina serie de televisio popular te com a protagonista a 'Sheldon Cooper'?",
        options = listOf("Big Bang Theory", "How I Met Your Mother", "Friends", "The Office"),
        correctAnswerIndex = 0,
        category = "Pop"
    ),
    Question(
        text = "Qui es coneix com la 'Diva del Pop'?",
        options = listOf("Britney Spears", "Madonna", "Lady Gaga", "Beyonce"),
        correctAnswerIndex = 1,
        category = "Pop"
    ),
    Question(
        text = "Quin es el nom del mag en 'El Mago d'Oz'?",
        options = listOf("El Mago d'Oz", "Merlin", "Gandalf", "Dumbledore"),
        correctAnswerIndex = 0,
        category = "Pop"
    )
)
