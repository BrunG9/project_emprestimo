package bruno.project.emprestimo.service;

import bruno.project.emprestimo.dto.CustomerRequestDTO;
import bruno.project.emprestimo.dto.LoanResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoanService {

    public List<LoanResponseDTO> determineLoans(CustomerRequestDTO customerRequestDTO){

        int age = customerRequestDTO.getAge();
        double income = customerRequestDTO.getIncome();
        String location = customerRequestDTO.getLocation();

        List<LoanResponseDTO> loans = new ArrayList<>();
        if(income <= 3000){
            loans.add(new LoanResponseDTO("PERSONAL", 4));
            loans.add(new LoanResponseDTO("GUARANTEED", 3));
        }
        if((income > 3000 && income <= 5000) && age < 30 && "SP".equalsIgnoreCase(location)){
            loans.add(new LoanResponseDTO("PERSONAL", 4));
            loans.add(new LoanResponseDTO("GUARANTEED", 3));
        }
        if(income >= 5000){
            loans.add(new LoanResponseDTO("CONSIGNMENT", 2));
        }

        return loans;
    }

}
