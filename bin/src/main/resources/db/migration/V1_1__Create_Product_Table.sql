CREATE TABLE `tb_product` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_product`
--
ALTER TABLE `tb_product`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_qht682qvopcx5f41dc2rbs5jf` (`name`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_product`
--
ALTER TABLE `tb_product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;
