# 🚗 Sistema de Controle de Estacionamento (Console)

Este projeto é um **Sistema de Controle de Estacionamento** desenvolvido em **Java**, com interface via **console**, como parte de um trabalho acadêmico da disciplina de Programação Orientada a Objetos.

O sistema permite o cadastro e controle de veículos e vagas, registro de entrada e saída, cálculo de tarifas e emissão de recibos, aplicando os principais conceitos de **POO** vistos em sala de aula.

---

## 📌 Funcionalidades

- Cadastro automático de vagas
- Registro de **entrada de veículos** (carro ou moto)
- Registro de **saída de veículos**
- Cálculo automático do valor a pagar de acordo com o tipo de veículo e tempo de permanência
- Emissão de **recibo**
- Listagem de:
  - vagas (livres e ocupadas)
  - veículos estacionados
  - recibos gerados

---

## 🧠 Conceitos de POO Utilizados

- **Classes e Objetos**
- **Encapsulamento** (atributos privados e métodos públicos)
- **Herança**
  - `Veiculo` (classe abstrata)
  - `Carro` e `Moto`
- **Polimorfismo**
- **Interfaces**
  - `Tarifavel`
- **Enum**
  - `TipoVeiculo`
  - `StatusVaga`
- **Record**
  - `Recibo`
- **Coleções**
  - `ArrayList`

