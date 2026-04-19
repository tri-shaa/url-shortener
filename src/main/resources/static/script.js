

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

    // extract code
    const code = shortUrl.split("/r/")[1];

    // fetch click count
    const statsResponse = await fetch(`/stats/${code}`);
    const statsText = await statsResponse.text();

    // display result with COPY BUTTON
    document.getElementById("result").innerHTML = `
        <p><strong>Short URL:</strong></p>

        <div style="display:flex; gap:10px; justify-content:center; align-items:center;">
            <a href="${shortUrl}" target="_blank" id="shortLink">${shortUrl}</a>
            <button onclick="copyLink()">Copy</button>
        </div>

        <p id="copyMsg" style="font-size:12px;"></p>

        <p id="clicks"><strong>${statsText}</strong></p>
    `;

    setInterval(async () => {
        const statsResponse = await fetch(`/stats/${code}`);
        const statsText = await statsResponse.text();

        document.getElementById("clicks").innerHTML = `<strong>${statsText}</strong>`;
    }, 2000);
}

// 👇 COPY FUNCTION
function copyLink() {
    const link = document.getElementById("shortLink").href;

    navigator.clipboard.writeText(link);

    document.getElementById("copyMsg").innerText = "Copied!";
}

