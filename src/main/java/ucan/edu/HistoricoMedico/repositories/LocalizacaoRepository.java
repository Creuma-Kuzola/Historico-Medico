package ucan.edu.HistoricoMedico.repositories;

//import edu.ucan.project1.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import ucan.edu.HistoricoMedico.entities.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, String> {

}
