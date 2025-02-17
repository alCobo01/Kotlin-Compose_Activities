package cat.itb.m78.exercices.trivial

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val category: String,
    val difficulty: String
)

var questions = listOf(
    // Historia - Easy (15)
    Question(
        text = "Quina civilitzacio va construir les piramides d'Egipte?",
        options = listOf("Egipcis", "Romans", "Grecs", "Maians"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin any va acabar la Segona Guerra Mundial?",
        options = listOf("1940", "1945", "1950", "1939"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin explorador va descobrir America el 1492?",
        options = listOf("Cristofor Colom", "Vasco da Gama", "Ferdinand Magellan", "Amerigo Vespucci"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Qui va ser el primer president dels Estats Units?",
        options = listOf("Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin any es va produir la caiguda del Mur de Berlin?",
        options = listOf("1989", "1991", "1985", "1990"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina guerra es va lluitar entre 1914 i 1918?",
        options = listOf("Guerra de Corea", "Primera Guerra Mundial", "Segona Guerra Mundial", "Guerra del Vietnam"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin imperi va dominar el Mediterrani durant segles?",
        options = listOf("Imperi Otoma", "Imperi Roma", "Imperi Bizanti", "Imperi Persa"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina cultura va construir Machu Picchu?",
        options = listOf("Incas", "Aztecs", "Olmecs", "Mayas"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin rei angles es va casar sis cops?",
        options = listOf("Enric VIII", "Joan Sense Terra", "Ricard III", "Carles I"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin any va començar la Revolucio Francesa?",
        options = listOf("1789", "1776", "1800", "1750"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin continent va ser colonitzat principalment per Espanya i Portugal?",
        options = listOf("Africa", "Asia", "America del Sud", "Oceania"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Qui va ser el primer home en viatjar a l'espai?",
        options = listOf("Neil Armstrong", "Yuri Gagarin", "Alan Shepard", "John Glenn"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin farao egipci es famos per la seva tomba descoberta intacta?",
        options = listOf("Ramses II", "Tutankamon", "Akhenaton", "Cleopatra"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina ciutat va ser destruida per l'erupcio del Vesubi l'any 79 dC?",
        options = listOf("Roma", "Atenes", "Pompeia", "Cartago"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin lider va encapcalar la marxa de la sal a l'India?",
        options = listOf("Mahatma Gandhi", "Jawaharlal Nehru", "Indira Gandhi", "Sardar Patel"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Easy"
    ),

    // Historia - Normal (15)
    Question(
        text = "Qui va ser una figura destacada de la Revolucio Francesa?",
        options = listOf("Napoleo", "Robespierre", "Luis XVI", "Voltaire"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina cultura va construir Machu Picchu?",
        options = listOf("Incas", "Aztecs", "Olmecs", "Mayas"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina guerra es va lluitar entre 1914 i 1918?",
        options = listOf("Guerra de Corea", "Primera Guerra Mundial", "Segona Guerra Mundial", "Guerra del Vietnam"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin imperi va dominar el Mediterrani durant segles?",
        options = listOf("Imperi Otoma", "Imperi Roma", "Imperi Bizanti", "Imperi Persa"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui va lluitar contra l'apartheid a Sud-africa?",
        options = listOf("Nelson Mandela", "Desmond Tutu", "F.W. de Klerk", "Steve Biko"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui va pintar el famos fresc 'La Creacio d'Adam' a la Capella Sixtina?",
        options = listOf("Leonardo da Vinci", "Michelangelo", "Raphael", "Donatello"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina civilitzacio va construir el Parteno d'Atenes?",
        options = listOf("Egipcia", "Romana", "Grega", "Persa"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "En quin segle va començar la Revolucio Industrial?",
        options = listOf("XVII", "XVIII", "XIX", "XX"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin moviment artistic i cultural va florir durant el segle XVI?",
        options = listOf("Barroc", "Renaixement", "Romanticisme", "Neoclassicisme"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina reina anglesa va regnar durant l'epoca d'or d'Anglaterra?",
        options = listOf("Isabel I", "Maria I", "Anna de Gran Bretanya", "Victoria"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin president americà va liderar els EUA durant la Guerra Civil?",
        options = listOf("George Washington", "Abraham Lincoln", "Thomas Jefferson", "Andrew Jackson"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina illa va ser el lloc d'exili de Napoléo Bonaparte després de Waterloo?",
        options = listOf("Còrsega", "Elba", "Santa Helena", "Sicília"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin any va començar la Guerra Freda?",
        options = listOf("1945", "1949", "1962", "1975"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina batalla va ser decisiva per la conquesta normanda d'Anglaterra el 1066?",
        options = listOf("Batalla de Hastings", "Batalla de Stamford Bridge", "Batalla de Tours", "Batalla de Agincourt"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin tractat va posar fi a la Primera Guerra Mundial?",
        options = listOf("Tractat de Versalles", "Tractat de Brest-Litovsk", "Tractat de Tordesillas", "Tractat de Westfàlia"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Normal"
    ),

    // Historia - Hard (15)
    Question(
        text = "En quin any va caure l'Imperi Roma d'Occident?",
        options = listOf("410", "476", "500", "395"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina civilitzacio antiga construia temples escalonats anomenats 'zigurat'?",
        options = listOf("Babilonica", "Egipcia", "Mesopotamica", "Persa"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina batalla va marcar la derrota final de Napoleo?",
        options = listOf("Austerlitz", "Trafalgar", "Leipzig", "Waterloo"),
        correctAnswerIndex = 3,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin era el nom de l'ultim emperador asteca abans de la conquesta espanyola?",
        options = listOf("Moctezuma II", "Cuauhtémoc", "Atahualpa", "Huayna Cápac"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin emperador roma va legalitzar el cristianisme amb l'Edicte de Milan?",
        options = listOf("Augusto", "Nero", "Constantino", "Teodosio"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina dinastia xinesa va construir la Gran Muralla Xinesa?",
        options = listOf("Han", "Ming", "Qin", "Song"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin any es va signar la Declaracio d'Independencia dels Estats Units?",
        options = listOf("1776", "1783", "1789", "1801"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin conflicte va ser conegut com la Guerra dels Cent Anys?",
        options = listOf("Guerra de les Roses", "Guerra dels Trenta Anys", "Guerra dels Cent Anys", "Guerra Civil Anglesa"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina reina va ser executada durant la Revolucio Francesa?",
        options = listOf("Maria Antonieta", "Isabel de Valois", "Anna d'Austria", "Caterina de Medici"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin any va començar la Guerra de Successio Espanyola?",
        options = listOf("1700", "1701", "1705", "1714"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin filòsof grec va ser mestre d'Aristotil?",
        options = listOf("Socrate", "Plato", "Heraclit", "Pitagora"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina batalla naval va ser decisiva en la derrota de l'Armada Invencible espanyola?",
        options = listOf("Batalla de Lepanto", "Batalla de Trafalgar", "Batalla de Gravelines", "Batalla de Actium"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin any es va produir el Gran Incendi de Roma sota l'emperador Nero?",
        options = listOf("64 dC", "79 dC", "100 dC", "300 dC"),
        correctAnswerIndex = 0,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Qui va ser el primer emperador de la dinastia Qin a Xina?",
        options = listOf("Wu de Han", "Gaozu de Han", "Qin Shi Huang", "Taizong de Tang"),
        correctAnswerIndex = 2,
        category = "Historia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin any es va fundar la Companyia Britanica de les Indies Orientals?",
        options = listOf("1500", "1600", "1650", "1700"),
        correctAnswerIndex = 1,
        category = "Historia",
        difficulty = "Hard"
    ),

    // Ciencia - Easy (15)
    Question(
        text = "Quin es l'element quimic amb el simbol 'O'?",
        options = listOf("Osmio", "Oxigen", "Or", "Oganesson"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin gas es essencial per a la respiracio humana?",
        options = listOf("Dioxid de carboni", "Oxigen", "Nitrogen", "Hidrogen"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin es el planeta mes proper al Sol?",
        options = listOf("Mart", "Venus", "Mercuri", "Terra"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin element quimic te el nombre atomic 1?",
        options = listOf("Heli", "Hidrogen", "Liti", "Carboni"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin instrument s'utilitza per mesurar la temperatura?",
        options = listOf("Barometre", "Termometre", "Higrometre", "Altimetre"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Com es diu la galaxia on es troba el sistema solar?",
        options = listOf("Andromeda", "Via Lactea", "Triangulum", "Magella Gran"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina formula quimica representa l'aigua?",
        options = listOf("CO2", "NaCl", "H2O", "O2"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin estat de la materia l'aigua es torna gel?",
        options = listOf("Gasos", "Plasma", "Solid", "Liquid"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin animal aquatic es famos per la seva inteligencia i aleta dorsal?",
        options = listOf("Foca", "Tauro", "Delfi", "Pingui"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina part de la planta fa la fotosintesi principalment?",
        options = listOf("Arrel", "Tija", "Fulla", "Flor"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quants ossos te aproximadament un esquelet huma adult?",
        options = listOf("106", "206", "306", "406"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin planeta del sistema solar es conegut com el 'planeta vermell'?",
        options = listOf("Jupiter", "Mart", "Saturn", "Urà"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina força fonamental manté units els atoms?",
        options = listOf("Gravitatoria", "Electromagnetica", "Nuclear forta", "Nuclear feble"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin dispositiu s'utilitza per veure objectes molt petits, com les cellules?",
        options = listOf("Telescopi", "Binocles", "Microscopi", "Periscopi"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin fenomen natural causa les marees oceaniques?",
        options = listOf("Vents", "Corrents marins", "Gravetat de la Lluna", "Temperatura de l'aigua"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Easy"
    ),

    // Ciencia - Normal (15)
    Question(
        text = "Quina teoria va formular Albert Einstein?",
        options = listOf("Teoria de la relativitat", "Teoria de l'evolucio", "Teoria quantica", "Teoria atomica"),
        correctAnswerIndex = 0,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina part del cos huma produeix la insulina?",
        options = listOf("Cor", "Fesss", "Pancrees", "Pulmons"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin cientific va proposar la llei de la gravitacio universal?",
        options = listOf("Isaac Newton", "Galileo Galilei", "Nikola Tesla", "Albert Einstein"),
        correctAnswerIndex = 0,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin organisme converteix la llum solar en energia?",
        options = listOf("Fongs", "Bacteris", "Algues", "Plantes"),
        correctAnswerIndex = 3,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina branca de la biologia estudia els animals?",
        options = listOf("Botanica", "Zoologia", "Geologia", "Astronomia"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es l'organ mes gran del cos huma?",
        options = listOf("Cor", "Pell", "Fetge", "Ronyo"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin proces utilitzen les plantes per fabricar el seu aliment?",
        options = listOf("Respiracio", "Digestio", "Fotosintesi", "Metabolisme"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina es la unitat basica de la vida?",
        options = listOf("Molecule", "Teixit", "Cellula", "Atom"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es el principal component de les estrelles?",
        options = listOf("Oxigen", "Hidrogen", "Carboni", "Heli"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin tipus d'energia es genera a partir d'una explosio nuclear?",
        options = listOf("Energia cinetica", "Energia quimica", "Energia electrica", "Energia nuclear"),
        correctAnswerIndex = 3,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quantes vertebres te aproximadament un huma adult?",
        options = listOf("26", "33", "41", "50"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es el nom complet de l'ADN?",
        options = listOf("Acid desoxiribonucleic", "Acid ribonucleic", "Acid desoxiribonucleico", "Acid ribodesoxiribonucleic"),
        correctAnswerIndex = 0,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin planeta del sistema solar te anells visibles desde la Terra?",
        options = listOf("Jupiter", "Urà", "Neptu", "Saturn"),
        correctAnswerIndex = 3,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin tipus de roca es el marbre?",
        options = listOf("Ignees", "Sedimentaries", "Metamorfiques", "Volcaniques"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina velocitat te la llum en el buit aproximadament?",
        options = listOf("300.000 km/s", "150.000 km/s", "500.000 km/s", "1.000.000 km/s"),
        correctAnswerIndex = 0,
        category = "Ciencia",
        difficulty = "Normal"
    ),

    // Ciencia - Hard (15)
    Question(
        text = "Quantes lleis de la termodinamica hi ha?",
        options = listOf("Dues", "Tres", "Quatre", "Cinc"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin es el nom de la teoria que descriu la formacio de l'Univers a partir d'una gran explosio?",
        options = listOf("Teoria del Big Crunch", "Teoria del Big Bang", "Teoria de l'estat estacionari", "Teoria inflacionaria"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina branca de la fisica estudia el comportament de la llum i altres radiacions electromagnetiques?",
        options = listOf("Mecanica cuantica", "Termodinamica", "Optica", "Acustica"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin es el nom de la part mes externa del nucli de la Terra?",
        options = listOf("Mantell", "Escorça", "Nucli intern", "Nucli extern"),
        correctAnswerIndex = 3,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin cientific va descobrir la penicilina?",
        options = listOf("Marie Curie", "Louis Pasteur", "Alexander Fleming", "Robert Koch"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin metall alcali te el nombre atomic mes alt?",
        options = listOf("Sodi", "Potassi", "Rubidi", "Cesi"),
        correctAnswerIndex = 3,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina proteina es responsable del transport d'oxigen en la sang dels vertebrats?",
        options = listOf("Colagen", "Hemoglobina", "Insulina", "Miosina"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin component subatomic te carrega neutra?",
        options = listOf("Proto", "Electro", "Neutro", "Positro"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin cientific va formular les lleis del moviment planetari?",
        options = listOf("Copernic", "Kepler", "Galileo", "Brahe"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin element transuranic te el simbol 'Pu'?",
        options = listOf("Americi", "Neptu", "Pluto", "Curi"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina particula elemental es considerada un fermio i un lepton?",
        options = listOf("Quark", "Foton", "Neutri", "Gluo"),
        correctAnswerIndex = 2,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin es el nom de l'escala de magnitud sismica logaritmica que quantifica l'energia alliberada en un terratremol?",
        options = listOf("Escala de Mercalli", "Escala de Richter", "Escala de Beaufort", "Escala de Saffir-Simpson"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin acid nucleic es unicament de cadena senzilla i conté uracil en lloc de timina?",
        options = listOf("ADN", "ARN", "ARNm", "ARNt"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin terme descriu el punt en l'orbita d'un planeta o cometa on es troba mes allunyat del Sol?",
        options = listOf("Periheli", "Afeli", "Zenit", "Nadir"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin principi fisic estableix que la entropia total d'un sistema aillat sempre augmenta amb el temps?",
        options = listOf("Principi d'incertesa de Heisenberg", "Segona llei de la termodinamica", "Principi de conservacio de l'energia", "Principi de relativitat general"),
        correctAnswerIndex = 1,
        category = "Ciencia",
        difficulty = "Hard"
    ),

    // Esports - Easy (15)
    Question(
        text = "Quin esport es juga amb una pilota i una raqueta a la ma?",
        options = listOf("Basquet", "Tenis", "Voleibol", "Futbol"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin esport s'organitza una marato?",
        options = listOf("Natacio", "Ciclisme", "Atletisme", "Esqui"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport d'equip compta amb porters?",
        options = listOf("Futbol", "Basquet", "Rugbi", "Voleibol"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quants anells hi ha en el simbol dels Jocs Olimpics?",
        options = listOf("3", "5", "7", "9"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin estil de natacio es coneix com 'papallona'?",
        options = listOf("Crol", "Braça", "Esquena", "Papallona"),
        correctAnswerIndex = 3,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin esport s'utilitza un tauler amb caselles blanques i negres?",
        options = listOf("Escacs", "Dards", "Billar", "Bitlles"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport es juga amb una pilota ovalada i es fa servir un placatge?",
        options = listOf("Futbol", "Basquet", "Rugbi", "Tennis"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin esport es fa servir un 'puck'?",
        options = listOf("Futbol", "Hoquei sobre gel", "Basquet", "Golf"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport es practica amb una taula i onades?",
        options = listOf("Esqui aquatic", "Surf", "Windsurf", "Piraguisme"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin esport s'utilitza una bicicleta?",
        options = listOf("Atletisme", "Natacio", "Ciclisme", "Esgrima"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport implica colpejar una pilota amb un basto en un camp de gespa?",
        options = listOf("Golf", "Criquet", "Beisbol", "Tennis"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport es juga en una pista de gel i amb patins?",
        options = listOf("Patinatge artistic", "Curling", "Hoquei sobre gel", "Patinatge de velocitat"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport consisteix en saltar amb una perxa?",
        options = listOf("Salt de llargada", "Triple salt", "Salt d'alçada", "Salt amb perxa"),
        correctAnswerIndex = 3,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "En quin esport es fa servir un 'putter'?",
        options = listOf("Tennis", "Golf", "Basquet", "Futbol"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin esport aquatic es practica amb una vela i una taula?",
        options = listOf("Piraguisme", "Rem", "Windsurf", "Natacio sincronitzada"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Easy"
    ),

    // Esports - Normal (15)
    Question(
        text = "Quin pais va guanyar la Copa del Mond de Futbol el 2010?",
        options = listOf("Alemania", "Italia", "Espanya", "Brasil"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es el nom de la competicio europea de futbol interclubs?",
        options = listOf("Champions League", "Copa del Rei", "Supercopa", "Lliga"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui es conegut com el 'Rei del Futbol'?",
        options = listOf("Lionel Messi", "Cristiano Ronaldo", "Pele", "Diego Maradona"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin esport utilitza un basto llarg i un disc volador?",
        options = listOf("Hoquei sobre herba", "Basquet", "Voleibol", "Rugbi"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "En quin esport s'utilitza una canya per jugar?",
        options = listOf("Golf", "Podel", "Ciclisme", "Esgrima"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin pais ha guanyat mes titols en la Copa del Mond de Futbol?",
        options = listOf("Alemania", "Brasil", "Argentina", "Franca"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin esport te com a principal trofeu la 'Stanley Cup'?",
        options = listOf("Hoquei sobre gel", "Basquet", "Futbol american", "Lacrosse"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui es conegut com el 'GOAT' del basquet?",
        options = listOf("LeBron James", "Kobe Bryant", "Michael Jordan", "Magic Johnson"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "En quin esport s'utilitza una pala i una pilota petites, sovint jugat a taules?",
        options = listOf("Tenis de taula", "Billar", "Badminton", "Ping-pong"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin esport s'associa amb el rem?",
        options = listOf("Rem", "Natacio", "Ciclisme", "Atletisme"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin esport implica lluitar en un ring?",
        options = listOf("Lluita lliure", "Boxa", "Judo", "Taekwondo"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin pais va acollir els Jocs Olimpics de 1992?",
        options = listOf("Atenes", "Barcelona", "Sydney", "Atlanta"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "En ciclisme, quina 'gran volta' es corre al maig?",
        options = listOf("Giro d'Italia", "Tour de Francia", "Vuelta a Espanya", "Volta a Catalunya"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quants jugadors hi ha en un equip de basquet?",
        options = listOf("5", "7", "9", "11"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin estil de natacio es coneix com 'esquena'?",
        options = listOf("Crol", "Braça", "Esquena", "Papallona"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Normal"
    ),

    // Esports - Hard (15)
    Question(
        text = "Quin equip de la NBA va ser el primer en guanyar 70 partits en una temporada regular?",
        options = listOf("Chicago Bulls (1995-96)", "Los Angeles Lakers (1971-72)", "Boston Celtics (1985-86)", "Golden State Warriors (2015-16)"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "En tennis, quants 'Grand Slam' componen el 'Career Golden Slam'?",
        options = listOf("3", "4", "5", "6"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin golfista ha guanyat mes tornejos 'Major'?",
        options = listOf("Jack Nicklaus", "Tiger Woods", "Arnold Palmer", "Gary Player"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quants minuts dura un partit de basquet de la NBA?",
        options = listOf("40 minuts", "48 minuts", "52 minuts", "60 minuts"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin esport de motor utilitza monoplaces amb rodes descobertes i es corre en circuits tancats?",
        options = listOf("MotoGP", "Formula 1", "Rally", "NASCAR"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quants sets necesita guanyar un jugador per guanyar un partit de tennis 'Grand Slam' masculi?",
        options = listOf("2 sets", "3 sets", "4 sets", "5 sets"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin equip de beisbol ha guanyat mes 'World Series'?",
        options = listOf("New York Yankees", "Boston Red Sox", "Los Angeles Dodgers", "San Francisco Giants"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "En futbol, quants jugadors hi ha en un equip titular (sense comptar el porter)?",
        options = listOf("9", "10", "11", "12"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quants 'downs' te un equip de futbol americà per avanzar 10 iardes?",
        options = listOf("2 downs", "3 downs", "4 downs", "5 downs"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin pais ha guanyat mes medalles d'or en els Jocs Olimpics d'estiu?",
        options = listOf("Unio Sovietica", "Xina", "Estats Units", "Alemanya"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "En ciclisme, quina cursa es coneix com 'L'infern del Nord'?",
        options = listOf("Milan-San Remo", "Paris-Roubaix", "Tour de Flandes", "Lieja-Bastogne-Lieja"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quants 'innings' hi ha en un partit de beisbol professional?",
        options = listOf("7 innings", "8 innings", "9 innings", "10 innings"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "En quin esport es fa servir el terme 'birdie'?",
        options = listOf("Tennis", "Badminton", "Golf", "Beisbol"),
        correctAnswerIndex = 2,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin equip de futbol de la NFL ha guanyat mes 'Super Bowls'?",
        options = listOf("Dallas Cowboys", "New England Patriots", "Pittsburgh Steelers", "Green Bay Packers"),
        correctAnswerIndex = 1,
        category = "Esports",
        difficulty = "Hard"
    ),
    Question(
        text = "En boxa, quants assalts hi ha en un combat professional no titular?",
        options = listOf("10 assalts", "12 assalts", "8 assalts", "4 assalts"),
        correctAnswerIndex = 0,
        category = "Esports",
        difficulty = "Hard"
    ),

    // Pop - Easy (15)
    Question(
        text = "Qui es l'autor de la saga 'Harry Potter'?",
        options = listOf("J.R.R. Tolkien", "J.K. Rowling", "Stephen King", "George R.R. Martin"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina serie de televisio tracta sobre un grup d'amics a Nova York?",
        options = listOf("Friends", "The Office", "How I Met Your Mother", "Seinfeld"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin videojoc presenta personatges com Mario i Luigi?",
        options = listOf("Sonic", "Super Mario", "Zelda", "Pac-Man"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina serie de televisio popular te com a protagonista a 'Sheldon Cooper'?",
        options = listOf("Big Bang Theory", "How I Met Your Mother", "Friends", "The Office"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin personatge de Disney es una sirena?",
        options = listOf("Blancaneu", "La Sireneta", "La Bella", "Cenicienta"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin videojoc de Nintendo te com a protagonista a un personatge amb una gorra vermella i bigoti?",
        options = listOf("Zelda", "Pokemon", "Mario", "Donkey Kong"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin artista musical es conegut per la canço 'Like a Virgin'?",
        options = listOf("Cyndi Lauper", "Madonna", "Britney Spears", "Kylie Minogue"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin personatge de 'Star Wars' es un robot daurat i parla fluidament diversos idiomes?",
        options = listOf("R2-D2", "C-3PO", "BB-8", "Wall-E"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina d'aquestes pel·lícules de Disney es protagonitzada per una nena que viu a Hawaii?",
        options = listOf("Frozen", "Moana", "Lilo & Stitch", "Vaiana"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin grup musical britanic va ser famos per les seves perruques i maquillatge?",
        options = listOf("The Rolling Stones", "The Beatles", "Queen", "Kiss"),
        correctAnswerIndex = 3,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin personatge de dibuixos animats viu en una pinya al fons del mar?",
        options = listOf("Mickey Mouse", "SpongeBob SquarePants", "Bugs Bunny", "Garfield"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina plataforma de streaming es coneguda pel seu logotip vermell i la 'N'?",
        options = listOf("HBO Max", "Amazon Prime Video", "Netflix", "Disney+"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin actor interpreta a 'Iron Man' en les pel·lícules de Marvel?",
        options = listOf("Chris Evans", "Chris Hemsworth", "Robert Downey Jr.", "Mark Ruffalo"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quina canco de Nadal es famosa per la frase 'All I want for Christmas is you'?",
        options = listOf("Last Christmas", "Jingle Bells", "White Christmas", "All I Want for Christmas Is You"),
        correctAnswerIndex = 3,
        category = "Pop",
        difficulty = "Easy"
    ),
    Question(
        text = "Quin d'aquests videojocs es un joc de construccio de blocs molt popular?",
        options = listOf("Fortnite", "Minecraft", "Roblox", "Among Us"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Easy"
    ),

    // Pop - Normal (15)
    Question(
        text = "Quin superheroi diu 'Amb gran poder ve una gran responsabilitat'?",
        options = listOf("Batman", "Superman", "Spider-Man", "Iron Man"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui es el creador dels comics de 'Batman'?",
        options = listOf("Stan Lee", "Bob Kane", "Jack Kirby", "Alan Moore"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin artista va llancar l'album 'Thriller'?",
        options = listOf("Prince", "Elvis Presley", "Michael Jackson", "Madonna"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "En quin any es va estrenar la primera pellicula de 'Star Wars'?",
        options = listOf("1977", "1980", "1969", "1983"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es el nom del robot en la pellicula 'Wall-E'?",
        options = listOf("EVE", "R2-D2", "BB-8", "C-3PO"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin cantant es coneix com el 'Rei del Pop'?",
        options = listOf("Elvis Presley", "Michael Jackson", "Prince", "Freddie Mercury"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina serie de televisio te com a protagonista un professor de quimica convertit en cap d'un imperi de drogues?",
        options = listOf("The Sopranos", "Breaking Bad", "Ozark", "Narcos"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin es el nom del continent fictici de 'Game of Thrones'?",
        options = listOf("Westeros", "Narnia", "Middle-earth", "Hogwarts"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin grup musical va ser famos amb la canco 'Bohemian Rhapsody'?",
        options = listOf("The Beatles", "Queen", "Nirvana", "Led Zeppelin"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Qui es coneix com la 'Diva del Pop'?",
        options = listOf("Britney Spears", "Madonna", "Lady Gaga", "Beyonce"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin actor interpreta a 'Jack Sparrow' a 'Pirates del Carib'?",
        options = listOf("Brad Pitt", "Johnny Depp", "Orlando Bloom", "Keira Knightley"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina pel·lícula de Pixar te com a protagonista un peix pallasso anomenat Nemo?",
        options = listOf("Toy Story", "Buscant en Nemo", "Monstres S.A.", "Els Increïbles"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin cantant va interpretar la canco principal de la pel·lícula de James Bond 'Skyfall'?",
        options = listOf("Adele", "Sam Smith", "Billie Eilish", "Duran Duran"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quin d'aquests no es un membre original dels 'Beatles'?",
        options = listOf("John Lennon", "Paul McCartney", "George Harrison", "Mick Jagger"),
        correctAnswerIndex = 3,
        category = "Pop",
        difficulty = "Normal"
    ),
    Question(
        text = "Quina famosa saga cinematografica te una espasa laser com a arma iconica?",
        options = listOf("Star Trek", "Matrix", "El Senyor dels Anells", "Star Wars"),
        correctAnswerIndex = 3,
        category = "Pop",
        difficulty = "Normal"
    ),

    // Pop - Hard (15)
    Question(
        text = "Quin actor va interpretar tant a 'Hannibal Lecter' com a 'Odin' en el cinema?",
        options = listOf("Anthony Hopkins", "Mads Mikkelsen", "Gary Oldman", "Benedict Cumberbatch"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin director de cinema es conegut per l'ús freqüent de la 'Golden Ratio' en la seva cinematografia?",
        options = listOf("Christopher Nolan", "Stanley Kubrick", "Quentin Tarantino", "Alfred Hitchcock"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina canco de videojoc es coneguda per ser impossible de completar en mode expert en 'Guitar Hero III: Legends of Rock'?",
        options = listOf("Through the Fire and Flames", "Free Bird", "Jordan", "Barracuda"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin artista musical va popularitzar el 'Moonwalk'?",
        options = listOf("Elvis Presley", "James Brown", "Michael Jackson", "Prince"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin grup de rock progresiu es conegut per l'album conceptual 'The Dark Side of the Moon'?",
        options = listOf("Led Zeppelin", "Pink Floyd", "Genesis", "Yes"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina pel·lícula de ciencia-ficcio explora conceptes de somnis dins de somnis i nivells de consciencia?",
        options = listOf("Origen", "Matrix", "Interestellar", "Blade Runner"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin director de cinema es famos per utilitzar seqüencies de somnis i simbolisme psicoanalitic en les seves pel·lícules?",
        options = listOf("David Lynch", "Terry Gilliam", "Darren Aronofsky", "Alejandro Jodorowsky"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina serie de televisio de ciencia-ficcio explora temes de viatges en el temps, realitats alternatives i bucles temporals?",
        options = listOf("Stranger Things", "Black Mirror", "Dark", "Westworld"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin videojoc de rol massiu en línia (MMORPG) es conegut pel seu món expansiu d'Azeroth i la seva lluita entre l'Aliança i l'Horda?",
        options = listOf("Final Fantasy XIV", "The Elder Scrolls Online", "World of Warcraft", "Guild Wars 2"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin artista de comic es conegut per crear obres mestres grafiques com 'Watchmen', 'V de Vendetta' i 'The Killing Joke'?",
        options = listOf("Frank Miller", "Alan Moore", "Neil Gaiman", "Grant Morrison"),
        correctAnswerIndex = 1,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina banda de rock alternatiu va popularitzar el so 'grunge' a la decada de 1990 amb cancons com 'Smells Like Teen Spirit'?",
        options = listOf("Pearl Jam", "Soundgarden", "Alice in Chains", "Nirvana"),
        correctAnswerIndex = 3,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin director de cinema es conegut per les seves pel·lícules de ciencia-ficcio amb temes filosòfics com 'Blade Runner 2049' i 'Arrival'?",
        options = listOf("Denis Villeneuve", "Christopher Nolan", "Ridley Scott", "James Cameron"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin famos musical de Broadway explica la historia d'un fantasma que persegueix una opera de Paris?",
        options = listOf("Cats", "Les Miserables", "El Fantasma de l'Opera", "Wicked"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quin actor es conegut per interpretar a 'Neo' en la trilogia de 'Matrix'?",
        options = listOf("Keanu Reeves", "Laurence Fishburne", "Hugo Weaving", "Carrie-Anne Moss"),
        correctAnswerIndex = 0,
        category = "Pop",
        difficulty = "Hard"
    ),
    Question(
        text = "Quina popular serie de televisió de ciencia-ficcio te un metge extraterrestre que viatja en el temps i l'espai amb una cabina telefonica anomenada 'TARDIS'?",
        options = listOf("Star Trek", "The X-Files", "Doctor Who", "Battlestar Galactica"),
        correctAnswerIndex = 2,
        category = "Pop",
        difficulty = "Hard"
    )
)
