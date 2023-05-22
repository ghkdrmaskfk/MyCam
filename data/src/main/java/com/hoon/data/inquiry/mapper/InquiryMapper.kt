package com.hoon.data.inquiry.mapper

import com.hoon.data.inquiry.dto.BasedItemInfoDto
import com.hoon.data.inquiry.dto.ImageDto
import com.hoon.data.inquiry.dto.ImageItemInfoDto
import com.hoon.data.utils.default
import com.hoon.domain.inquiry.model.BasedInfoVo
import com.hoon.domain.inquiry.model.ImageInfoItemsVo
import com.hoon.domain.inquiry.model.ImageInfoVo

fun List<BasedItemInfoDto>.mapperToBasedInfoVo(): List<BasedInfoVo> {
    val list = arrayListOf<BasedInfoVo>()
    forEach {
        list.add(
            BasedInfoVo(
            it.contentId.default(),
            it.facltNm.default(),
            it.lineIntro.default(),
            it.intro.default(),
            it.allar.default(),
            it.insrncAt.default(),
            it.trsagntNo.default(),
            it.bizrno.default(),
            it.facltDivNm.default(),
            it.mangeDivNm.default(),
            it.mgcDiv.default(),
            it.manageSttus.default(),
            it.hvofBgnde.default(),
            it.hvofEnddle.default(),
            it.featureNm.default(),
            it.induty.default(),
            it.lctCl.default(),
            it.doNm.default(),
            it.sigunguNm.default(),
            it.zipcode.default(),
            it.addr1.default(),
            it.addr2.default(),
            it.mapX.default(),
            it.mapY.default(),
            it.direction.default(),
            it.tel.default(),
            it. homepage.default(),
            it.resveUrl.default(),
            it.resveCl.default(),
            it.manageNmpr.default(),
            it.gnrlSiteCo.default(),
            it.autoSiteCo.default(),
            it.glampSiteCo.default(),
            it.caravSiteCo.default(),
            it.indvdlCaravSiteCo.default(),
            it.sitedStnc.default(),
            it.siteMg1Width.default(),
            it.siteMg2Width.default(),
            it.siteMg3Width.default(),
            it.siteMg1Vrticl.default(),
            it.siteMg2Vrticl.default(),
            it.siteMg3Vrticl.default(),
            it.siteMg1Co.default(),
            it.siteMg2Co.default(),
            it.siteMg3Co.default(),
            it.siteBottomCl1.default(),
            it.siteBottomCl2.default(),
            it.siteBottomCl3.default(),
            it.siteBottomCl4.default(),
            it.siteBottomCl5.default(),
            it.tooltip.default(),
            it.glampInnerFclty.default(),
            it.caravInnerFclty.default(),
            it.prmisnDe.default(),
            it.operPdCl.default(),
            it.operDeCl.default(),
            it.trlerAcmpnyAt.default(),
            it.caravAcmpnyAt.default(),
            it.toiletCo.default(),
            it.swrmCo.default(),
            it.wtrplCo.default(),
            it.brazierCl.default(),
            it.sbrsCl.default(),
            it.sbrsEtc.default(),
            it.posblFcltyCl.default(),
            it.posblFcltyEtc.default(),
            it.clturEventAt.default(),
            it.clturEvent.default(),
            it.exprnProgrmAt.default(),
            it.exprnProgrm.default(),
            it.extshrCo.default(),
            it.frprvtWrppCo.default(),
            it.frprvtSandCo.default(),
            it.fireSensorCo.default(),
            it.themaEnvrnCl.default(),
            it.eqpmnLendCl.default(),
            it.animalCmgCl.default(),
            it.tourEraCl.default(),
            it.firstImageUrl.default(),
            it.createdtime.default(),
            it.modifiedtime.default())
        )
    }
    return list
}

fun List<ImageItemInfoDto>.mapperToImageInfoVo(): List<ImageInfoVo> {
    val list = arrayListOf<ImageInfoVo>()
    forEach {
        list.add(
            ImageInfoVo(
                it.contentId.default(),
                it.serialnum.default(),
                it.imageUrl.default(),
                it.createdtime.default(),
                it.modifiedtime.default())
        )
    }
    return list
}