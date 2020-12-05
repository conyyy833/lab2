LAB2
 - name: Deploy eureka Service
        uses: akhileshns/heroku-deploy@v3.6.8
        with:
          heroku_api_key: ${{secrets.HEROKU_API_KEY}}
          heroku_app_name: eureka-shop-app
          heroku_email: conyyy833@gmail.com
          appdir: "shop/eureka"