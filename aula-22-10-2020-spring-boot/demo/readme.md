# Sites para pesquisar após a aula

- https://cafe.algaworks.com/esr-lista-de-espera/
- https://cafe.algaworks.com/sri-aula3-gwk/?utm_campaign=popup&utm_source=site-aw&utm_medium=org
- https://www.udemy.com/course/spring-boot-ionic/
- https://blog.algaworks.com/chega-de-nullpointerexception/
- https://www.devmedia.com.br/programacao-funcional-codigo-limpo-e-padroes-de-projeto/32902

---


## Anotações Diversas:

### Utilização de DTO
A utilização do padrão DTO ajuda na transferência de dados sem comprometer nossa API, veja mais em: https://medium.com/@msealvial/blindando-sua-api-spring-boot-com-o-padrão-dto-44f97020d1a0

### Optional - ClienteRepository
Utilizado para resolver o problema de NullPointerException quando era retornado null em buscas.

- modo para retornar um Optional: `Optional.of(variable)`

### Modificações no ClienteController
Agora, com a implementação do Optional, nossos métodos em Controller se tornaram mais "enxutos", uma vez que todo o tratamento do erro 404 (not found) é realizado dentro da nossa classe de serviço (ClienteService). Essa forma de estruturação é considerada mais correta pois previne possíveis erros decorrentes do que antes utilizávamos ao retornar um null caso determinado cadastro não fosse encontrado.

### Alteração no aplication.properties
O seguinte código foi inserido no arquivo aplication.properties para retirar um erro de trace ao fazer uma busca de um cadastro não encontrado.
    'server.error.include-stacktrace = never'

