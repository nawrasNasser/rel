INSERT INTO public.admin_user (id, password, email, name, is_active) VALUES
  ('1', '$2a$10$bMx0b6BkaeBTw4mFE5aKP.Um280VNaWtTEm1b7fr1bQEFoP0Cj7sy', 'nawras.nasser@mail.ru', 'nawras', TRUE);

INSERT INTO public.admin_user_role (id, name, description) VALUES
  ('1', 'admin', 'super');


INSERT INTO public.admin_user_to_role ("admin_user_id", "admin_role_id") VALUES
  (1, 1);


