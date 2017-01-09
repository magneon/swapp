==================================================================================================================================================
==================================================================================================================================================
=========================================================== STAR WARS APPLICATION ================================================================
==================================================================================================================================================
==================================================================================================================================================

O objetivo desse arquivo é demonstrar como foi desenvolvido e como deve ser utilizado o sistema swapp.

Tecnologias utilizadas:

- swapi.co 		# Serviço que contém a alimentação do sistema, como naves, planetas e tripulação.
- junit			# API para testes unitários.
- primefaces	# Framework front-end para visualização dos dados do WS.

Estrutura do projeto:

swapp/META-INF/
swapp/META-INF/MANIFEST.MF
swapp/content-basic.xhtml
swapp/footer-basic.xhtml
swapp/header-basic.xhtml
swapp/index.xhtml
swapp/menu-basic.xhtml
swapp/pages/
swapp/pages/naves/
swapp/pages/naves/naves.xhtml
swapp/pages/planetas/
swapp/pages/planetas/planetas.xhtml
swapp/pages/plano/
swapp/pages/plano/plano-novo.xhtml
swapp/pages/tripulacao/
swapp/pages/tripulacao/tripulacao.xhtml
swapp/resources/
swapp/resources/css/
swapp/resources/js/
swapp/resources/primefaces/
swapp/resources/primefaces/images/
swapp/resources/primefaces/plugins/
swapp/resources/primefaces/themes/
swapp/WEB-INF/
swapp/WEB-INF/web.xml
swapp/WEB-INF/lib/
swapp/WEB-INF/lib/activation-1.1.jar
swapp/WEB-INF/lib/all-themes-1.0.10.jar
swapp/WEB-INF/lib/commons-codec-1.2.jar
swapp/WEB-INF/lib/commons-httpclient-3.1.jar
swapp/WEB-INF/lib/commons-logging-1.0.4.jar
swapp/WEB-INF/lib/gson-2.3.1.jar
swapp/WEB-INF/lib/httpclient-4.0.3.jar
swapp/WEB-INF/lib/httpcore-4.0.1.jar
swapp/WEB-INF/lib/jackson-annotations-2.8.0.jar
swapp/WEB-INF/lib/jackson-core-2.8.5.jar
swapp/WEB-INF/lib/jackson-databind-2.8.5.jar
swapp/WEB-INF/lib/javassist-3.12.1.GA.jar
swapp/WEB-INF/lib/jaxrs-api-2.2.2.GA.jar
swapp/WEB-INF/lib/jcip-annotations-1.0.jar
swapp/WEB-INF/lib/jsf-api-2.1.11.jar
swapp/WEB-INF/lib/jsf-impl-2.1.11.jar
swapp/WEB-INF/lib/jsr250-api-1.0.jar
swapp/WEB-INF/lib/okhttp-2.7.5.jar
swapp/WEB-INF/lib/okio-1.6.0.jar
swapp/WEB-INF/lib/primefaces-6.0.jar
swapp/WEB-INF/lib/resteasy-jaxrs-2.2.2.GA.jar
swapp/WEB-INF/lib/retrofit-1.9.0.jar
swapp/WEB-INF/lib/scannotation-1.0.3.jar
swapp/WEB-INF/lib/swapi-java-1.0-SNAPSHOT.jar
swapp/WEB-INF/classes/
swapp/WEB-INF/classes/br/
swapp/WEB-INF/classes/br/com/
swapp/WEB-INF/classes/br/com/mootit/
swapp/WEB-INF/classes/br/com/mootit/comparators/
swapp/WEB-INF/classes/br/com/mootit/controllers/
swapp/WEB-INF/classes/br/com/mootit/converters/
swapp/WEB-INF/classes/br/com/mootit/models/
swapp/WEB-INF/classes/br/com/mootit/util/
swapp/WEB-INF/classes/br/com/mootit/comparators/NaveComparator.class
swapp/WEB-INF/classes/br/com/mootit/comparators/PlanetaComparator.class
swapp/WEB-INF/classes/br/com/mootit/comparators/TripulanteComparator.class
swapp/WEB-INF/classes/br/com/mootit/controllers/BaseController.class
swapp/WEB-INF/classes/br/com/mootit/controllers/MenuController.class
swapp/WEB-INF/classes/br/com/mootit/controllers/NaveController.class
swapp/WEB-INF/classes/br/com/mootit/controllers/PlanetaController.class
swapp/WEB-INF/classes/br/com/mootit/controllers/PlanoVooController.class
swapp/WEB-INF/classes/br/com/mootit/controllers/TripulacaoController.class
swapp/WEB-INF/classes/br/com/mootit/converters/ClimaConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/DiametroConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/PassageiroConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/PopulacaoConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/TerrenoConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/TripulacaoQuantidadeConverter.class
swapp/WEB-INF/classes/br/com/mootit/converters/TripulacaoSexoConverter.class
swapp/WEB-INF/classes/br/com/mootit/models/Nave.class
swapp/WEB-INF/classes/br/com/mootit/models/Planeta.class
swapp/WEB-INF/classes/br/com/mootit/models/PlanoVoo.class
swapp/WEB-INF/classes/br/com/mootit/models/Tripulante.class
swapp/WEB-INF/classes/br/com/mootit/util/StarWarsUtil$1.class
swapp/WEB-INF/classes/br/com/mootit/util/StarWarsUtil$2.class
swapp/WEB-INF/classes/br/com/mootit/util/StarWarsUtil$3.class
swapp/WEB-INF/classes/br/com/mootit/util/StarWarsUtil.class
swapp/META-INF/maven/br.com.mootit/swapp/pom.xml
swapp/META-INF/maven/br.com.mootit/swapp/pom.properties

Servidor de aplicação utilizado:

- apache-tomcat-7.0.73

Como utilizar:

1) Realizar o deploy da aplicação na pasta 'webapps' do servidor de aplicação.
2) Executar via prompt de comando o arquivo 'startup.bat' da pasta /bin do servidor de aplicação.
3) Acessar via browser a URI: http://localhost:8080/swapp

Funções do sistema:

A. Naves
	1. Consulta
		Essa funcionalidade permite ao usuário realizar uma pesquisa por todas as naves disponíveis do serviço swapi.co;
		Existe uma limitação de 5 chamadas ao serviço do swapi, pois acredito que seja suficiente para o teste.
		Não há filtros nessa tela.	
B. Planetas
	1. Consulta
		Permite ao usuário consultar alguns planetas disponíveis do serviço swapi.co;
		Existe uma limitação de 5 chamadas ao serviço swapi, pois acredito que seja suficiente para o teste.
		Não há filtros nessa tela.
C. Tripulação
	1. Consulta
		Permite ao usuário consultar alguns tripulantes disponíveis do serviço swapi.co
		Existe uma limitação de 5 chamadas ao serviço swapi, pois acredito que seja suficiente para o teste.
		Não há filtros nessa tela.
D. Plano de Vôo
	1. Criação de Plano de Vôo
		Essa tela permite ao usuário criar os planos de vôo dos hangares.
		Ela possui quatro divisões: Planeta, Nave, Tripulação e Planos de Vôos.
		As divisões Planeta e Nave, possuem um grid para seleção dos respectivos valores.
		A divisão Tripulação, contém um campo para que o usuário preencha o quantidade de tripulantes e um botão para criação.
		Os seguintes cenários barram a criação do plano de vôo:
			D.1.1. Planeta não selecionado;
			D.1.2. Nave não selecionada;
			D.1.3. Tripulação com caracteres alfanuméricos;
			D.1.4. Plano de Vôo com o mesmo Planeta do Plano de Vôo anterior;
			D.1.5. Tripulação maior que a capacidade da nave.
		Após as validações serem feitas pelo sistema, um novo cenário será exibido na lista da quarta divisão 'Plano de Vôo'.

Endereço no git:

