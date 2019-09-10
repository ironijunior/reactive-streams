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
      - 
      
    - resilientes
      - resistente à falhas através de replicação + ???
      - cada serviço sabe como tratar suas falhas
      
    - elásticos
      - escaláveis (horizontalmente ou verticalmente)
        - vertical = recurso de maquina
        - horizontal = instâncias
        
    - orientados a mensagens
      - mensageria assíncrona para comunicação entre os serviços
        - diminui o acoplamento entre os serviços
      - permite monitoramento das filas para realizar *back-pressure* e controlar throughput (escalabilidade)
