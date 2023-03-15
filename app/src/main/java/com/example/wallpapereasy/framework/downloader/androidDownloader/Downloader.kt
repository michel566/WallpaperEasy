package com.example.wallpapereasy.framework.downloader.androidDownloader

interface Downloader {
    fun downloadFile(url: String, description: String): Long
}