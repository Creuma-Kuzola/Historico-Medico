package ucan.edu.HistoricoMedico.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ucan.edu.HistoricoMedico.entities.DatasourceConfig;
import ucan.edu.HistoricoMedico.repositories.DatasourceConfigRepository;

@Component
public class TenantDataSource implements Serializable {

    private HashMap<String, DataSource> dataSources = new HashMap<>();

    @Autowired
    private DatasourceConfigRepository configRepo;

    public DataSource getDataSource(String name) {
        if (dataSources.get(name) != null) {
            return dataSources.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if (dataSource != null) {
            dataSources.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll() {
        List<DatasourceConfig> configList = configRepo.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DatasourceConfig config : configList) {
            DataSource dataSource = getDataSource(config.getTenantId());
            result.put(config.getTenantId(), dataSource);
        }
        return result;
    }

    private DataSource createDataSource(String tenantId) {
        DatasourceConfig config = configRepo.findByTenantId(tenantId);
        if (config != null) {
            DataSourceBuilder factory = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getUrl());
            DataSource ds = factory.build();
            return ds;
        }
        return null;
    }

}
