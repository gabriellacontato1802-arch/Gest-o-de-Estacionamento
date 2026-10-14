# Gestão de Estacionamento

Aplicação de console em Java que calcula o valor cobrado por veículo e gera um relatório de fechamento do expediente.

## Regras de negócio
| Permanência | Valor |
|---|---|
| Até 1 hora | R$ 10,00 |
| 2 a 3 horas | R$ 10,00 + R$ 5,00 por hora adicional |
| Acima de 3 horas | Diária fixa de R$ 30,00 |

- Veículos elétricos têm **20% de desconto**.
- Capacidade de atendimento: 4 veículos por expediente.
- Entradas inválidas (horas ≤ 0 ou tipo diferente de 1 e 2) são repetidas.

## Relatório de fechamento
Total de veículos atendidos, total arrecadado, quantidade de convencionais e elétricos, e veículos com tarifa diária.

## Como executar
javac GestaoEstacionamento.java
java GestaoEstacionamento

## Próximos passos
- Tratar entradas não numéricas
- Separar a lógica em métodos/classes
- Trocar valores fixos por constantes
