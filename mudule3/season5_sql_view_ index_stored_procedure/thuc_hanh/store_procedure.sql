use classicmodels;
-- Tạo procedure
DELIMITER //

CREATE PROCEDURE findAllCustomers()

BEGIN

  SELECT * FROM customers;

END //

DELIMITER ;

-- Gọi
 call findAllCustomers();
 
 -- Xóa

DROP PROCEDURE `findAllCustomers`;


