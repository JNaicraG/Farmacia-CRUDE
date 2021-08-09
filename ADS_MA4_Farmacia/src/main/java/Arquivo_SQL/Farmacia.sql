-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.6.0-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Copiando estrutura para tabela farmacia.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `IDCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` char(60) NOT NULL,
  `CPF` char(60) NOT NULL,
  `Email` char(60) NOT NULL,
  `Telefone` int(10) DEFAULT NULL,
  `Celular` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela farmacia.cliente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`IDCliente`, `Nome`, `CPF`, `Email`, `Telefone`, `Celular`) VALUES
	(2, 'Nicol Bolas', '45696859851', 'nicol.bolas@141', 1144748450, 1196029183),
	(7, 'qeweqweqw', '12', 'asdsadasd', 142131, 1241);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Copiando estrutura para tabela farmacia.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `IDPedido` int(11) NOT NULL AUTO_INCREMENT,
  `IDCliente` int(11) DEFAULT NULL,
  `IDRemedio` int(11) DEFAULT NULL,
  `Quantidade` int(11) DEFAULT 1,
  `Preco` float DEFAULT NULL,
  PRIMARY KEY (`IDPedido`),
  KEY `FK_pedido_cliente` (`IDCliente`),
  KEY `FK_pedido_remedios` (`IDRemedio`),
  CONSTRAINT `FK_pedido_cliente` FOREIGN KEY (`IDCliente`) REFERENCES `cliente` (`IDCliente`),
  CONSTRAINT `FK_pedido_remedios` FOREIGN KEY (`IDRemedio`) REFERENCES `remedios` (`IDRemedio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela farmacia.pedido: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;

-- Copiando estrutura para tabela farmacia.remedios
CREATE TABLE IF NOT EXISTS `remedios` (
  `IDRemedio` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` char(60) DEFAULT NULL,
  `Categoria` char(60) DEFAULT NULL,
  `Receita` char(15) DEFAULT NULL,
  `Codigo` int(11) DEFAULT NULL,
  `Preco` float DEFAULT NULL,
  PRIMARY KEY (`IDRemedio`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela farmacia.remedios: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `remedios` DISABLE KEYS */;
INSERT INTO `remedios` (`IDRemedio`, `Nome`, `Categoria`, `Receita`, `Codigo`, `Preco`) VALUES
	(2, 'aspirina', 'analgésico', 'não', 123, 13),
	(6, 'asdassa', 'a', 'asdas', 321, 12),
	(7, 'zxczxsada', 'a', 'não', 333, 13),
	(8, 'xxxxxxxxxxxxxxxxxxx', 'da', 'aaaaaa', 1234, 15);
/*!40000 ALTER TABLE `remedios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
