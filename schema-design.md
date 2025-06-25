# MySQL Database Schema Design

Este documento descreve o esquema de banco de dados MySQL com pelo menos quatro tabelas principais, seus campos, tipos de dados e relacionamentos por chave estrangeira.

## Tabela: `usuarios`
- `id` INT PRIMARY KEY AUTO_INCREMENT
- `nome` VARCHAR(100) NOT NULL
- `email` VARCHAR(100) UNIQUE NOT NULL
- `senha` VARCHAR(255) NOT NULL
- `tipo_usuario` ENUM('medico', 'paciente', 'admin') NOT NULL

## Tabela: `pacientes`
- `id` INT PRIMARY KEY AUTO_INCREMENT
- `usuario_id` INT NOT NULL
- `data_nascimento` DATE
- `telefone` VARCHAR(20)
- FOREIGN KEY (`usuario_id`) REFERENCES `usuarios`(`id`)

## Tabela: `medicos`
- `id` INT PRIMARY KEY AUTO_INCREMENT
- `usuario_id` INT NOT NULL
- `crm` VARCHAR(20) UNIQUE NOT NULL
- `especialidade` VARCHAR(100)
- FOREIGN KEY (`usuario_id`) REFERENCES `usuarios`(`id`)

## Tabela: `consultas`
- `id` INT PRIMARY KEY AUTO_INCREMENT
- `paciente_id` INT NOT NULL
- `medico_id` INT NOT NULL
- `data_consulta` DATETIME NOT NULL
- `observacoes` TEXT
- FOREIGN KEY (`paciente_id`) REFERENCES `pacientes`(`id`)
- FOREIGN KEY (`medico_id`) REFERENCES `medicos`(`id`)

## Tabela: `prescricoes`
- `id` INT PRIMARY KEY AUTO_INCREMENT
- `consulta_id` INT NOT NULL
- `descricao` TEXT NOT NULL
- `data_prescricao` DATE NOT NULL
- FOREIGN KEY (`consulta_id`) REFERENCES `consultas`(`id`)
