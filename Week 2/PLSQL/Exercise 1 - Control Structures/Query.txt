Scenario 1: Apply 1% Discount to Interest Rate if Age > 60

BEGIN
  FOR cust IN (SELECT customer_id, loan_id, interest_rate, age FROM customers c JOIN loans l ON c.customer_id = l.customer_id)
  LOOP
    IF cust.age > 60 THEN
      UPDATE loans
      SET interest_rate = interest_rate - 1
      WHERE loan_id = cust.loan_id;
    END IF;
  END LOOP;
  COMMIT;
END;


Scenario 2: Promote to VIP if Balance > $10,000

BEGIN
  FOR cust IN (SELECT customer_id, balance FROM customers)
  LOOP
    IF cust.balance > 10000 THEN
      UPDATE customers
      SET isVIP = 'TRUE'
      WHERE customer_id = cust.customer_id;
    END IF;
  END LOOP;
  COMMIT;
END;


Scenario 3: Send Reminder for Loans Due Within 30 Days

BEGIN
  FOR rec IN (
    SELECT l.loan_id, c.customer_id, c.name, l.due_date
    FROM loans l
    JOIN customers c ON c.customer_id = l.customer_id
    WHERE l.due_date <= SYSDATE + 30
  )
  LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.name || ' has a loan (ID: ' || rec.loan_id || ') due on ' || TO_CHAR(rec.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
