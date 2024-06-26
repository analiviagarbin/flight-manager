# Relatório #

Ana Flor de Oliveira Stefani    4770143
Ana Lívia de Magalhães Garbin  14557394
Nícolas Martins de Oliveira    14600902

1. **Requisitos.**

​	O programa desenvolvido deve apresentar um sistema de gerenciamento de voos para aeroportos. Para isso, devemos seguir os seguintes requisitos quando olhamos para o seu desenvolvimento:

​	1.1.**Funcionalidades do sistema:**

​		1.1.1. Registro de aeroportos:

​			Conta com o código do aeroporto, a cidade onde é localizado e a lista de voos associados a ele.

​		1.1.2. Requisitos de voos:

​			Deve fornecer ao usuário o nome da cidade de destino do voo pesquisado, o código do voo, horário de decolagem e de pouso, assim como o número de passageiros no voo e o status do viagem.

​		1.1.3. Remoção:

​			Deve ser possível remover aeroportos do sistema e remover voos associados a um aeroporto em específico.

​		1.1.4. Listar:

​			Listar tanto voos de um aeroporto em específico quanto listar todos os voos disponíveis.

​		1.1.5. Atualização:

​		Deve ser possível ao usuário atualizar o status do voo, para indicar se ele chegou ao seu destino ou não.

​	1.2. **Requisitos adicionais:**

​		1.2.1. Validação de dados:

​			O sistema apresenta checagem de dados para garantir se os dados inseridos pelo usuário são válidos, assim como se o código do aeroporto é único ou se o voo existe antes de removê-lo ou alterar seu status.

​		1.2.2. User Interface (GUI):	

​			A interface é pensada para ser user-friendly e intuitiva. Para isso, devem ser seguidos requisitos baseados na tarefa, como: Deve ser bem estruturada, as aplicações e telas devem cobrir todas as funcionalidades listadas acima.

​		1.2.3. Base de dados;

​			Guardar e acessar informações por meio de arquivos.



2. **Descrição do Projeto.**

​	2.1. **Classes do sistema:**

​		O Sistema conta com duas classes principais:

​		2.1.1. Airports:

​			- Atributos: 

​				String AirportCode (para o codigo do aeroporto)

​				String CityName (para a cidade onde é localizado)

​				List<Flights>flight (uma lista dos voos associados ao aeroporto)

​		 	- Construtores: 

​				Airport (Airport Model) 

​				Airports (contém as Strings cityName e airportCode).

​			- Metodos: 

​				void addFlight(): adicionar voo;

​				String getAirportCode(): retorna o codigo do aeroporto.

​				String getCity(): retorna a cidade onde está localizado.

​				List <Flights> getFlights(): retorna uma lista de todos os voos de um determinado aeroporto.

​				void removeFlight(): remove um voo.

​				void setAirportCode(): “coloca” um codigo no aeroporto.

​				void setCity(): seleciona a cidade onde o aeroporta está.

​		2.1.2. Flights:

​			- Atributos:

​				String cityName: Nome da cidade de destino.

​				int code: codigo do voo.

​				String departureTime: Hora da partida..

​				String arrivalTime: Hora da chegada.

​				int passengerCount: Número de passageiros.

​				boolean hasArrived: Status se chegou ou não.

​			- Construtores:

​				Flights: construtor.

​			- Metodos:

​				 String getCityName(): Retorna a o nome da cidade de destino.

​				int getCode(): Retorna o codigo do voo.

​				String getDepartureTime(): Retorna o horario da partida.

​				String getArrivalTime():Retorna o horário da chegada.

​				int getPassengerCount(): Retorna o niumero de passageiros.

​				boolean getHasArrived(): Retorna o status do voo.

​				void setHasArrived(boolean status): Mostra status do voo.

2.2. **Funcionalidades do sistema:**

​	O sistema oferece um menu principal usando uma interface gráfica onde os usuários podem acessar as diferentes funcionalidades relacionadas aos aeroportos e aos voos. As funcionalidades disponíveis são:

​	2.2.1. Adicionar aeroporto.

​		input: Nome da cidade e código do aeroporto.

​		Cria um novo objeto Airports e o adiciona na lista de aeroportos. 

​	2.2.2. Remover aeroporto.

​		input: Código do aeroporto.

​		Remove o objeto Airports correspondente ao código da lista de aeroportos.

​	2.2.3. Adicionar voos.

​		input: código do aeroporto, nome da cidade de destino, número do voo, horários de partida e chegada e número de passageiros.

​		Cria um novo objeto Flights e o adiciona à lista de voos de um aeroporto em específico.

​	2.2.4. Remover voos.

​		input: Código do aeroporto, nome da cidade de destino e número do voo.

​		Remove todos os voos correspondentes ao número do voo da lista de voos de um aeroporto em específico.

​	2.2.5. Lista voos de um aeroporto:

​		input: Código do aeroporto.

​		Mostra a lista de todos os voos cadastrados daquele aeroporto em específico.

​	2.2.6. Lista de todos os voos:

​		Mostra uma lista de todos os voos registrados no sistema.

​	2.2.7. Atualização do status do voo:

​		input: Código do aeroporto, número do voo e status.

​		Atualiza o atributo do objeto Flights correspondente. 

3. **Sobre o Código.**

Para melhor entendinento sobre o projeto, aqui estão algune pontos pertinentes sobre a implementacao que fizemos:

​	3.1. **Estrutura do projeto.**

​		O projeto está organizado em três principais diretórios: app, forms, e tests. O diretório app contém a lógica principal, forms lida com a interface gráfica e tests inclui os testes para verificar a funcionalidade do sistema

​	3.2.  **Classe Airports.**

​		Contém os métodos para adicionar, remover e listar os voos. 

​	3.3.   **Classe Flights.**

​	Responsável por armazenar informações sobre cada voo, incluindo destino, código do voo, horários de partida e chegada, número de passageiros e status de chegada. Métodos getter e setter são fornecidos para manipular esses dados.

​	3.4.  **Manipulação de dados.**

​	Os dados dos aeroportos são armazenados em um arquivo de texto (airports.txt). A leitura e escrita neste arquivo são gerenciadas para persistência dos dados, permitindo que as informacoes sejam mantidas entre as execuções do programa.

​	3.5.  **Interface Grafica (GUI) .**

​	O diretório forms contém os arquivos relacionados à interface gráfica do usuário (GUI), que facilita a interação com o sistema de forma intuitiva.

​	3.6. **Validação de dados:**

​	Implementação de validações para garantir que os códigos de aeroportos sejam únicos e que voos existentes possam ser removidos ou atualizados corretamente.

4. **Plano de Testes.**

Para nossa aplicação, decidimos adotar testes unitários para garantir que todas as funcionalidades estivessem funcionando conforme planejado nas especificações iniciais. Utilizando o padrão AAA (Arrange, Act, Assert), escrevemos testes que asseguram que as classes responsáveis pelas operações na aplicação funcionem corretamente.

Planejamos também realizar testes end-to-end (E2E), que simulam a aplicação como um todo. Esses testes seriam cruciais para garantir que o sistema funcionasse desde a interface visual (UI/UX) até as camadas mais profundas da aplicação, validando o fluxo completo do usuário. No entanto, enfrentamos dificuldades na implementação eficaz desses testes, o que nos impediu de prosseguir com sucesso nessa área.

Testes de interface também são essenciais para validar o comportamento dos componentes da tela. Contudo, enfrentamos limitações com JUnit, que não possui bibliotecas robustas e simples para testes de interface. Isso nos levou a concluir que investir tempo na tentativa de implementar esses testes com JUnit não seria produtivo. Essa experiência ressalta a importância de escolher tecnologias que ofereçam um conjunto completo de ferramentas (toolchain) para a aplicação.

Com base nesses desafios, reconhecemos a necessidade de procurar outras uma abordagens para testes. Consideramos a integração de outras ferramentas e frameworks que possam complementar os testes unitários, como Selenium para testes de interface e Cypress para testes end-to-end. Essas ferramentas são projetadas especificamente para lidar com os desafios de testes de end-to-end em interfaces webs, proporcionando uma cobertura de testes mais completa e confiável. Porém nada foi encontrado para aplicações desktop

Em resumo, nossa experiência reforça a importância de uma abordagem diversificada e bem suportada para testes de software. Ao combinar testes unitários com ferramentas especializadas para testes de interface e end-to-end, podemos garantir uma cobertura de testes abrangente que valida tanto as funcionalidades individuais quanto a integração e a experiência do usuário final.

5. **Resultados.**

Com base em nossa experiência de testes vimos a importância de uma estratégia de testes contínua, onde os testes são executados automaticamente em cada alteração de código, garantindo a integridade e a funcionalidade da aplicação ao longo do tempo. Essa abordagem não só melhora a qualidade do software, escrevendo uma documentação viva, mas também aumenta a eficiência do processo de desenvolvimento, permitindo a identificação e a correção rápida de erros. 

6. **Build Procedure.**

Requisitos:

- Java 17 (Foi utilizada a corretto 17)
- JUnit 4
- JUnit 5.8.1
- testing

​	Build:

​		```make build``` ou ```javac -d ./out -sourcepath ./ forms/main.java``` na raíz do projeto

​	
​	Run:

​		```make run``` ou ```java -cp ./out forms.main```



​	Opicional:

​		- Configuração de debug para IntelliJ

```
<component name="ProjectRunConfigurationManager">
  <configuration default="false" name="main" type="Application" factoryName="Application" nameIsGenerated="true">
    <option name="MAIN_CLASS_NAME" value="forms.main" />
    <module name="flight-manager" />
    <extension name="coverage">
      <pattern>
        <option name="PATTERN" value="forms.*" />
        <option name="ENABLED" value="true" />
      </pattern>
    </extension>
    <method v="2">
      <option name="Make" enabled="true" />
    </method>
  </configuration>
</component>
```



7. **Problemas.**

No desenvolvimento do projeto, vários problemas surgiram. Conflitos de versão e problemas de build ocorreram entre membros da equipe, devido à dificuldade em seguir um padrão consistente de JDK e bibliotecas. A complexidade da interface gráfica com Swing gerou código difícil de manter, e ajustes frequentes na UI introduziram bugs. Problemas de desempenho, embora pequenos, surgiram devido à falta de otimização da interface, tornando a aplicação lenta, especialmente em computadores mais antigos. A falta de experiência com Swing e UX no grupo resultou em uma implementação ineficiente e com baixa qualidade visual. A ausência de testes automatizados para a interface dificultou a detecção de erros visuais e de usabilidade. Além disso, a integração de novas funcionalidades foi desafiadora devido à arquitetura inflexível do código existente em Swing, complicando ainda mais a manutenção e evolução do software.

8. **Comentários.**

Desenvolver a atividade foi uma ótima oprtunidade de colocar em prática os conceitos ensinados durante o semestre. Permitiu a aplicação prática de diversos conceitos aprendidos, como encapsulamento, herança e composição; assim como trabalhar com manipulacao de dados e interface grafica foi de grande ajuda para solidificar esses conhecimentos teoricos.
