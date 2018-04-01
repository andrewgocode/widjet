IF OBJECT_ID('queue', 'U') IS NOT NULL
  DROP TABLE queue;
IF OBJECT_ID('payments', 'U') IS NOT NULL
  DROP TABLE payments;
IF OBJECT_ID('main_statistic', 'U') IS NOT NULL
  DROP TABLE main_statistic;
IF OBJECT_ID('contracts', 'U') IS NOT NULL
  DROP TABLE contracts;
IF OBJECT_ID('users', 'U') IS NOT NULL
  DROP TABLE users;
IF OBJECT_ID('roles', 'U') IS NOT NULL
  DROP TABLE roles;

CREATE TABLE roles
(
  id   INTEGER IDENTITY (1, 1) PRIMARY KEY,
  name NVARCHAR(255) NOT NULL
);


CREATE TABLE users
(
  id      INTEGER IDENTITY (1, 1) PRIMARY KEY,
  name    NVARCHAR(255),
  irps_id INTEGER,
  role_id  INTEGER       NOT NULL,
  password NVARCHAR(255) NOT NULL,
  FOREIGN KEY (role_id) REFERENCES roles (id)
    ON DELETE CASCADE
);

CREATE TABLE contracts
(
  id              INTEGER IDENTITY (1, 1) PRIMARY KEY,
  name            NVARCHAR(255) NOT NULL,
  inn             NVARCHAR(12)  NOT NULL,
  sum             BIGINT       NOT NULL,
  quantity        BIGINT       NOT NULL,
  eps_ids         NVARCHAR(MAX) NOT NULL,
  eps_id_in  NVARCHAR(MAX) NOT NULL,
  quantity_eps_id NVARCHAR(50)  NOT NULL,
  reestr_mask NVARCHAR(255)  NOT NULL,
  user_id      INTEGER,
  FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE payments
(
  id          INTEGER IDENTITY (1, 1) PRIMARY KEY,
  date        DATE           NOT NULL,
  date_impl   DATETIME       NOT NULL,
  sum_taken   INTEGER NOT NULL,
  sum_sent    INTEGER NOT NULL,
  sum_comis   INTEGER NOT NULL,
  quantity INTEGER NOT NULL,
  contract_id INTEGER        NOT NULL,
  FOREIGN KEY (contract_id) REFERENCES contracts (id)
    ON DELETE CASCADE
);

CREATE TABLE queue
(
  id          INTEGER IDENTITY (1, 1) PRIMARY KEY,
  date        DATETIME       NOT NULL,
  type        INTEGER        NOT NULL,
  status      INTEGER        NOT NULL,
  date_from   DATE       ,
  date_to     DATE       ,
  param NVARCHAR(MAX)
);

CREATE TABLE main_statistic
(
  id INTEGER IDENTITY (1,1) PRIMARY KEY,
  contract_id INTEGER NOT NULL ,
  sum BIGINT NOT NULL ,
  quantity BIGINT NOT NULL ,
  potential_sum BIGINT NOT NULL ,
  potential_quantity BIGINT NOT NULL ,
  diff_sum BIGINT NOT NULL ,
  diff_quantity BIGINT NOT NULL ,
  month INTEGER NOT NULL ,
  year INTEGER NOT NULL ,
  FOREIGN KEY (contract_id) REFERENCES contracts (id)
);
