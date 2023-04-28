-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'tenmo2';

DROP DATABASE tenmo2;

DROP USER tenmo_owner;
DROP USER tenmo_appuser;