

CREATE TABLE public."admin_user"
(id bigint NOT NULL,
password character varying(256) NOT NULL,
email character varying(70),
name character varying(50),
is_active boolean,
CONSTRAINT admin_user_pk PRIMARY KEY (id))
WITH (
  OIDS=FALSE
);
ALTER TABLE public."admin_user"
  OWNER TO rel;

  CREATE TABLE public."admin_user_role"
(id bigint NOT NULL,
name character varying(50) NOT NULL,
description character varying(1000),
CONSTRAINT admin_user_role_pk PRIMARY KEY (id))
WITH (
  OIDS=FALSE
);
ALTER TABLE public."admin_user_role"
  OWNER TO rel;


 CREATE TABLE public."admin_user_to_role"
 (admin_user_id bigint NOT NULL,
     admin_role_id bigint NOT NULL,
     CONSTRAINT admin_user_to_role_pk PRIMARY KEY (admin_user_id,admin_role_id))

 WITH (
 OIDS=FALSE
 );
 ALTER TABLE public."admin_user_role"
     OWNER TO rel;

 ALTER TABLE admin_user_to_role ADD CONSTRAINT fk_admin_user_to_role_admin_user_id      FOREIGN KEY (admin_user_id) REFERENCES admin_user(id);
 ALTER TABLE admin_user_to_role ADD CONSTRAINT fk_admin_user_to_roles_admin_user_role    FOREIGN KEY (admin_role_id) REFERENCES admin_user_role(id);







