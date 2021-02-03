package vn.phuclee.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.phuclee.case_study.model.ContractDetail;
import vn.phuclee.case_study.services.contract.AttachServiceService;
import vn.phuclee.case_study.services.contract.ContractDetailService;
import vn.phuclee.case_study.services.contract.ContractService;

@Controller
@RequestMapping("contractDetail")
public class ContractDetailController {
    @Autowired
    ContractService contractService;
    @Autowired
    AttachServiceService attachService;
    @Autowired
    ContractDetailService contractDetailService;

    @GetMapping(value = "")
    public String showCreateForm(Model model) {
        model.addAttribute("contract", new ContractDetail());
        model.addAttribute("contractList", contractService.findAll());
        model.addAttribute("attachList", attachService.findAll());
        return "/contractDetail/create";
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        contractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("successMsg", "Create new contract detail: "+
                contractDetail.getContractDetailId() + " done");
        return "redirect:/contractDetail";
    }

}
