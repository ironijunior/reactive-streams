**reactive streams**?
  - para entender reactive streams precisamos voltar alguns anos no passado
  

## Uma grande aplicação (monolito)
  - dezenas de servidores
  - segundos de response-time
  - horas de downtime para manutenções/releases
  - gigabytes de dados
  
## com o passar do tempo as demandas foram mudando, e as demandas atuais não conseguem ser atendidas pelas arquiteturas que tínhamos antes
  - milissegundos de response-time
  - zero downtime
  - petabytes de dados
  
## 


  
## Reactive Manifesto
  - define o que são sistemas reativos
    - responsivos
      - gratificação instantanea
        - se demorar para responder o usuário vai embora
      - scroll infinito é bom exemplo
        - fetch the data before you could react to the button less
      
    - resilientes
      - sistemas distribuidos pelo mundo, milhares de pontos de falha
      - resistente à falhas através de replicação + ???
      - habilidade de se recuperar de falhas e seguir em frente
      - cada serviço sabe como tratar suas falhas      
      
    - elásticos
      - escaláveis (horizontalmente ou verticalmente)
        - vertical = recurso de maquina
        - horizontal = instâncias (best)
        - threads? não comentar, muito assunto para cobrir
        
    - orientados a mensagens
      - mensageria assíncrona para comunicação entre os serviços
        - diminui o acoplamento entre os serviços
        - aumenta isolamento dos serviços
        - *ex.: não compartilhar banco de dados*
      - permite monitoramento das filas para realizar *back-pressure* e controlar throughput (escalabilidade)

  - exemplo de reactive system: Google Docs (Google Drive)
    - várias pessoas acessando ao mesmo tempo
    - colaboração ao vivo
