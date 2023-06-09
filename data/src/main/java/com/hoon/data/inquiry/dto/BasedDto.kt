package com.hoon.data.inquiry.dto

data class BasedDto(var items: BasedItemDto)
data class BasedItemDto(var item: List<BasedItemInfoDto>)
data class BasedItemInfoDto(var contentId: String?,
                               var facltNm: String?,
                               var lineIntro: String?,
                               var intro: String?,
                               var allar: String?,
                               var insrncAt: String?,
                               var trsagntNo: String?,
                               var bizrno: String?,
                               var facltDivNm: String?,
                               var mangeDivNm: String?,
                               var mgcDiv: String?,
                               var manageSttus: String?,
                               var hvofBgnde: String?,
                               var hvofEnddle: String?,
                               var featureNm: String?,
                               var induty: String?,
                               var lctCl: String?,
                               var doNm: String?,
                               var sigunguNm: String?,
                               var zipcode: String?,
                               var addr1: String?,
                               var addr2: String?,
                               var mapX: String?,
                               var mapY: String?,
                               var direction: String?,
                               var tel: String?,
                               var homepage: String?,
                               var resveUrl: String?,
                               var resveCl: String?,
                               var manageNmpr: String?,
                               var gnrlSiteCo: String?,
                               var autoSiteCo: String?,
                               var glampSiteCo: String?,
                               var caravSiteCo: String?,
                               var indvdlCaravSiteCo: String?,
                               var sitedStnc: String?,
                               var siteMg1Width: String?,
                               var siteMg2Width: String?,
                               var siteMg3Width: String?,
                               var siteMg1Vrticl: String?,
                               var siteMg2Vrticl: String?,
                               var siteMg3Vrticl: String?,
                               var siteMg1Co: String?,
                               var siteMg2Co: String?,
                               var siteMg3Co: String?,
                               var siteBottomCl1: String?,
                               var siteBottomCl2: String?,
                               var siteBottomCl3: String?,
                               var siteBottomCl4: String?,
                               var siteBottomCl5: String?,
                               var tooltip: String?,
                               var glampInnerFclty: String?,
                               var caravInnerFclty: String?,
                               var prmisnDe: String?,
                               var operPdCl: String?,
                               var operDeCl: String?,
                               var trlerAcmpnyAt: String?,
                               var caravAcmpnyAt: String?,
                               var toiletCo: String?,
                               var swrmCo: String?,
                               var wtrplCo: String?,
                               var brazierCl: String?,
                               var sbrsCl: String?,
                               var sbrsEtc: String?,
                               var posblFcltyCl: String?,
                               var posblFcltyEtc: String?,
                               var clturEventAt: String?,
                               var clturEvent: String?,
                               var exprnProgrmAt: String?,
                               var exprnProgrm: String?,
                               var extshrCo: String?,
                               var frprvtWrppCo: String?,
                               var frprvtSandCo: String?,
                               var fireSensorCo: String?,
                               var themaEnvrnCl: String?,
                               var eqpmnLendCl: String?,
                               var animalCmgCl: String?,
                               var tourEraCl: String?,
                               var firstImageUrl: String?,
                               var createdtime: String?,
                               var modifiedtime: String?)