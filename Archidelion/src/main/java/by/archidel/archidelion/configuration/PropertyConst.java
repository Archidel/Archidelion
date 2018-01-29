package by.archidel.archidelion.configuration;

public final class PropertyConst {
	private PropertyConst() {
	}

	// Setting JDBC properties
	public static final String DB_DRIVER = "db.driver";
	public static final String DB_URL = "db.url";
	public static final String DB_USER = "db.user";
	public static final String DB_PASS = "db.password";
	// Setting Hibernate properties
	public static final String HBT_SHOW_SQL = "hibernate.show_sql";
	public static final String HBT_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	public static final String HBT_DIALECT = "hibernate.dialect";

	// Setting C3P0 properties
	public static final String C3P0_MIN_SIZE = "hibernate.c3p0.min_size";
	public static final String C3P0_MAX_SIZE = "hibernate.c3p0.max_size";
	public static final String C3P0_ACQUIRE_INCREMENT = "hibernate.c3p0.acquire_increment";
	public static final String C3P0_TIMEOUT = "hibernate.c3p0.timeout";
	public static final String C3P0_MAX_STATEMENTS = "hibernate.c3p0.max_statements";
}