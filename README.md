# xy-inc

Servidor REST que possui serviços que executa operações básicas (CRUD) de pontos de interesse (POIs) e existe um serviço que dado uma posição com coordernadas X e Y e a distância máxima, busca todos os POIs que estejam a uma distância menor ou igual a distância máxima do ponto de referência.

Tabela caminhos REST

URI | Method | Descrição | Parametros | Exemplo
--- | ------ | --------- | ---------- | ------
xy-inc/poi | GET | Busca todos os POIs | - | xy-inc/poi
xy-inc/poi/id | GET | Busca um POI pelo ID | - | xy-inc/poi/2
xy-inc/poi | POST | Persiste um POI | - | xy-inc/poi corpo da requisição: {"nome" :"Lanchonete","coordenadaX":"27","coordenadaY":"12"}
xy-inc/poi/id | DELETE | Remove um POI | - |  xy-inc/poi/2
xy-inc/poi/proximidade | GET | Busca todos os POIs que estejam a uma distância menor ou igual a distância máxima do ponto de referência. | coordenadaX->inteiro coordenadaY->inteiro distMax->inteiro|  xy-inc/poi/proximidade?coordenadaX=20&coordenadaY=10&distMax=10


O banco de dados utilizado é o MySql e os scripts estão na pasta SQL
