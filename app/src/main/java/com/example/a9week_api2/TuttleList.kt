package com.example.a9week_api2

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class TuttleList {
    @SerializedName("resultCode")
    @Expose
    var resultCode: String? = null

    @SerializedName("resultMsg")
    @Expose
    var resultMsg: String? = null

    @SerializedName("numOfRows")
    @Expose
    var numOfRows: String? = null

    @SerializedName("pageNo")
    @Expose
    var pageNo: String? = null

    @SerializedName("pageCount")
    @Expose
    var pageCount: String? = null

    @SerializedName("tatalCount")
    @Expose
    var totalCount: String? = null

    @SerializedName("pttld")
    @Expose
    var pttld: String? = null

    @SerializedName("spcKrNm")
    @Expose
    var spcKrNm: String? = null

    @SerializedName("spcScinmShort")
    @Expose
    var spcScinmShort: String? = null

    @SerializedName("nttyDltAt")
    @Expose
    var nttyDltAt: String? = null

    @SerializedName("nttyGndr")
    @Expose
    var nttyGndr: String? = null

    @SerializedName("nttyWght")
    @Expose
    var nttyWght: String? = null

    @SerializedName("nttyLt")
    @Expose
    var nttyLt: String? = null

    @SerializedName("nttyAcqstDe")
    @Expose
    var nttyAcqstDe: String? = null

    @SerializedName("dschrgDe")
    @Expose
    var dschrgDe: String? = null

    @SerializedName("dschrAsqsLcNm")
    @Expose
    var dschrAsqsLcNm: String? = null

    @SerializedName("mngPznlnstNm")
    @Expose
    var mngPznlnstNm: String? = null

    @SerializedName("mngInstNm")
    @Expose
    var mngInstNm: String? = null
}