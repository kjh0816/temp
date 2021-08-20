package com.base.newPeaceSystemBuild.controller

import com.base.newPeaceSystemBuild.service.VendorService
import com.base.newPeaceSystemBuild.vo.standard.Flower
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartRequest


@Controller
class UsrVendorController(
    private val vendorService: VendorService
) {



    @RequestMapping("/usr/vendor/explain")
    fun showRequest(): String{


        return "usr/vendor/explain"
    }

    @RequestMapping("/usr/vendor/request")
    fun showRequest(model: Model): String{

        val flowers: List<Flower> = vendorService.getFlowers()


        model.addAttribute("flowers", flowers)

        return "usr/vendor/request"
    }

    @RequestMapping("/usr/vendor/doRequest")
    @ResponseBody
    fun doRequest(
        multipartRequest: MultipartRequest
        ){

    }
}