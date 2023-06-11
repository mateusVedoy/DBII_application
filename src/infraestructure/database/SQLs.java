package infraestructure.database;

public enum SQLs {
    INTERACTION_AD_BY_USER("select * from table(interacoes_usuario_anuncios(?))"),
    COUNT_AVG_PROPOSES_BY_PROPERTY("select * from table(propostas_anuncio_imovel(?))"),
    INSERT_USER("DECLARE\n" +
            "  v_codigo INTEGER := seq_usuario.nextval;\n" +
            "  v_ativo VARCHAR2(10) := '1';\n" +
            "  v_nomecompleto VARCHAR2(50) := ?;\n" +
            "  v_cpf VARCHAR2(20) := ?;\n" +
            "  v_renda NUMBER := ?;\n" +
            "  v_tipoperfil INTEGER := ?;\n" +
            "  v_msg VARCHAR2(200);\n" +
            "BEGIN\n" +
            "  insere_usuario(v_codigo, v_ativo, v_nomecompleto, v_cpf, v_renda, v_tipoperfil, v_msg);\n" +
            "  ? := v_msg;\n" +
            "END;"),
    UPDATE_USER_PROFILE_TYPE("DECLARE\n" +
            "  v_codigo INT := ?;\n" +
            "  v_tipoperfil INT := ?;\n" +
            "BEGIN\n" +
            "  atualiza_tipoperfil(v_codigo, v_tipoperfil);\n" +
            "END;"),
    UPDATE_PROPERTY_DESCRIPTION("DECLARE\n" +
            "  v_codigo INT := ?;\n" +
            "  v_desc VARCHAR2(200) := ?;\n" +
            "  v_msg VARCHAR2(200);\n" +
            "BEGIN\n" +
            "  atualiza_descricao_imovel(v_codigo, v_desc, v_msg);\n" +
            "  ? := v_msg;\n" +
            "END;"),
    SELECT_ALL_PROPERTIES_WITH_ACTIVE_AD("{call listar_imoveis_com_anuncio_ativo(?)}"),
    SELECT_ALL_USERS("select * from usuario"),
    SELECT_ALL_PROPERTIES("select * from imovel"),
    SELECT_USER_BY_ID("select * from usuario where usr_codigo=?"),
	SELECT_PROPERTY_BY_ID("select * from imovel where imv_codigo=?");

    private final String sql;

    SQLs(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

}
