using Oracle.DataAccess.Client;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ReseauAdmissionAppLocale
{
    public partial class GestionDesSpectaclesEtRepresentation : Form
    {
        public bool MouseUpB = false;
        OracleConnection oraconnPrincipale = new OracleConnection();

        public GestionDesSpectaclesEtRepresentation(OracleConnection uneConnexion)
        {
            InitializeComponent();
            oraconnPrincipale = uneConnexion;
        }

        private void panel2_MouseDown(object sender, MouseEventArgs e)
        {
            panel1.BackColor = Color.FromArgb(46, 154, 96);
        }

        private void panel2_MouseEnter(object sender, EventArgs e)
        {
            panel1.BackColor = Color.FromArgb(136, 243, 186);
        }

        private void panel2_MouseUp(object sender, MouseEventArgs e)
        {
            if (MouseUpB)
                panel1.BackColor = Color.FromArgb(136, 243, 186);
            MouseUpB = false;
        }

        private void panel2_MouseLeave(object sender, EventArgs e)
        {
            panel1.BackColor = Color.FromArgb(97, 221, 155);
        }

        private void panel1_MouseDown(object sender, MouseEventArgs e)
        {
            panel2.BackColor = Color.FromArgb(46, 154, 96);
        }

        private void panel1_MouseEnter(object sender, EventArgs e)
        {
            panel2.BackColor = Color.FromArgb(136, 243, 186);
        }

        private void panel1_MouseLeave(object sender, EventArgs e)
        {
            panel2.BackColor = Color.FromArgb(97, 221, 155);
        }

        private void panel1_MouseUp(object sender, MouseEventArgs e)
        {
            if (MouseUpB)
                panel2.BackColor = Color.FromArgb(136, 243, 186);
            MouseUpB = false;
        }

        private void panel2_Click(object sender, EventArgs e)
        {
            Representation form = new Representation(oraconnPrincipale);

            form.ShowDialog();
            MouseUpB = true;
        }

        private void panel1_Click(object sender, EventArgs e)
        {
            GestionSpectacle form = new GestionSpectacle(oraconnPrincipale);

            form.ShowDialog();
            MouseUpB = true;
        }

        private void BTN_Fermer_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
