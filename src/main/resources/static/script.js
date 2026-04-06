async function shortenUrl() {
    const url = document.getElementById("urlInput").value;

    const response = await fetch("/shorten", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ url: url })
    });

    const shortUrl = await response.text();



        document.getElementById("result").innerHTML =
            `<a href="${shortUrl}" target="_blank">${shortUrl}</a>`;
}