package com.crud.financeiro.controller;

import com.crud.financeiro.dto.RelatorioContasAReceber;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {

    @GetMapping("/contasAReceber")
    public ModelAndView relatorioContasAReceber() {
        ModelAndView mv = new ModelAndView("relatorio/ContasAReceber");
        mv.addObject(new RelatorioContasAReceber());
        return mv;
    }

    @PostMapping("/contasAReceber")
    public ModelAndView gerarRelatorioContasAReceber(RelatorioContasAReceber relatorioContasAReceber) {
        Map<String, Object> parametros = new HashMap<>();

        parametros.put("format", "pdf");
        parametros.put("dataDe", relatorioContasAReceber.getData_inicio());
        parametros.put("dataAte", relatorioContasAReceber.getData_fim());

        return new ModelAndView("relatorio_contas_a_receber", parametros);
    }

}
