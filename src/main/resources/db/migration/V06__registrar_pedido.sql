INSERT INTO `tartaros`.`pedido` (`id`, `data`, `valor_itens`, `valor_taxa_entrega`, `valor_total`, `status`, `valor_pago`, `valor_troco`, `observacao`, `id_forma_pagamento`, `id_promocao`, `id_canal_venda`, `id_cliente`) VALUES ('1', '2017-12-10 22:00:00', NULL, '7', '47', '1', '50', '3', NULL, '3', NULL, '1', '2');

INSERT INTO `tartaros`.`historico_pedido` (`id`, `data_hora`, `id_status`, `id_pedido`) VALUES ('1', '2017-12-10 22:00:00', '1', '1');

INSERT INTO `tartaros`.`item` (`id`, `valor`, `id_produto`, `id_pedido`) VALUES ('1', '22', '1', '1');
INSERT INTO `tartaros`.`item` (`id`, `valor`, `id_produto`, `id_pedido`) VALUES ('2', '20', '3', '1');

INSERT INTO `tartaros`.`sub_item` (`id`, `valor`, `id_complemento`, `id_item`) VALUES ('1', '0', '1', '1');
INSERT INTO `tartaros`.`sub_item` (`id`, `valor`, `id_complemento`, `id_item`) VALUES ('2', '2', '5', '1');
INSERT INTO `tartaros`.`sub_item` (`id`, `valor`, `id_complemento`, `id_item`) VALUES ('3', '0', '4', '2');


INSERT INTO permissao (id, nome) values (16, 'ROLE_CADASTRAR_PROMOCOES');
INSERT INTO permissao (id, nome) values (17, 'ROLE_PESQUISAR_PROMOCOES');
INSERT INTO permissao (id, nome) values (18, 'ROLE_REMOVER_PROMOCOES');
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 16);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 17);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 18);

INSERT INTO permissao (id, nome) values (19, 'ROLE_CADASTRAR_FORMA_PGTO');
INSERT INTO permissao (id, nome) values (20, 'ROLE_PESQUISAR_FORMA_PGTO');
INSERT INTO permissao (id, nome) values (21, 'ROLE_REMOVER_FORMA_PGTO');
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 19);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 20);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 21);

INSERT INTO permissao (id, nome) values (22, 'ROLE_CADASTRAR_CANAL_VENDA');
INSERT INTO permissao (id, nome) values (23, 'ROLE_PESQUISAR_CANAL_VENDA');
INSERT INTO permissao (id, nome) values (24, 'ROLE_REMOVER_CANAL_VENDA');
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 22);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 23);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 24);

INSERT INTO permissao (id, nome) values (25, 'ROLE_CADASTRAR_STATUS');
INSERT INTO permissao (id, nome) values (26, 'ROLE_PESQUISAR_STATUS');
INSERT INTO permissao (id, nome) values (27, 'ROLE_REMOVER_STATUS');
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 25);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 26);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 27);

INSERT INTO permissao (id, nome) values (28, 'ROLE_CADASTRAR_PEDIDOS');
INSERT INTO permissao (id, nome) values (29, 'ROLE_PESQUISAR_PEDIDOS');
INSERT INTO permissao (id, nome) values (30, 'ROLE_REMOVER_PEDIDOS');
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 28);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 29);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 30);
