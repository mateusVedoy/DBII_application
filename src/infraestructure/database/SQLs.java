package infraestructure.database;

public enum SQLs {
    INTERACTION_AD_BY_USER("select * from table(interacoes_usuario_anuncios(?);"),
    COUNT_AVG_PROPOSES_BY_PROPERTY("select * from table(propostas_anuncio_imovel(?));"),
    INSERT_USER("DECLARE\n" +
            "  v_codigo INTEGER := seq_usuario.nextval;\n" +
            "  v_ativo VARCHAR2(10) := '1';\n" +
            "  v_nomecompleto VARCHAR2(50) := 'João';\n" +
            "  v_cpf VARCHAR2(20) := '323.347.086-24';\n" +
            "  v_renda NUMBER := 1200;\n" +
            "  v_tipoperfil INTEGER := 1;\n" +
            "  v_msg VARCHAR2(200);\n" +
            "BEGIN\n" +
            "  insere_usuario(v_codigo, v_ativo, v_nomecompleto, v_cpf, v_renda, v_tipoperfil, v_msg);\n" +
            "  DBMS_OUTPUT.PUT_LINE(v_msg);\n" +
            "END;"),
    LIST_ALL_PROPERTIES_WITH_ACTIVE_AD("EXEC listar_imoveis_com_anuncio_ativo");

    private final String sql;

    SQLs(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
