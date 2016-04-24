CREATE TABLE users
(
  username character varying(100) NOT NULL,
  password character varying(100) NOT NULL,
  enabled boolean DEFAULT true,
  locked boolean DEFAULT false,
  failed_logins integer DEFAULT 0,
  last_login_date timestamp without time zone,
  CONSTRAINT "PK_USER" PRIMARY KEY (username)
);

CREATE TABLE roles
(
  id integer NOT NULL,
  name character varying(50) NOT NULL,
  CONSTRAINT "PK_ROLES" PRIMARY KEY (id)
);


CREATE TABLE authorities
(
  "user" character varying(50) NOT NULL,
  role integer NOT NULL,
  CONSTRAINT "PK_AUTHORITIES" PRIMARY KEY ("user", role),
  CONSTRAINT "FK_ROLE" FOREIGN KEY (role)
      REFERENCES roles (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "FK_USER" FOREIGN KEY ("user")
      REFERENCES users (username) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO users VALUES ('bytestree', '12345', true, false, 0);
INSERT INTO users VALUES ('admin', '12345', true, false, 0);

INSERT INTO authorities VALUES ('bytestree', 1);
INSERT INTO authorities VALUES ('admin', 1);
INSERT INTO authorities VALUES ('admin', 2);
